package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jface.text.Document;

import ModelBugSim.BuggyMethod;
import utility.Constants;
import utility.MethodVisitor;
import utility.Parser;

public class BuggyCodeExtractor {
	
	private List<BuggyMethod> buggyMethodList = new ArrayList<BuggyMethod>();

	public BuggyCodeExtractor() {
	}
	
	public void extract() throws IOException {
	     BufferedReader reader = new BufferedReader(
	    		 new FileReader(Constants.bugLocationDataFilePatth));
	     String currentLine = reader.readLine();
	     while(currentLine != null) {
	    	 String[] elements = currentLine.split("@");
		     String project = elements[0];
		     String path = elements[1];
		     String[] bugPositionLineNumbers = elements[2].split("[,-]");
		     
		     String buggyFIlePath = Constants.d4jRootPath + "/" + project + "/" + path;
//		     System.out.println(buggyFIlePath);
		     
		     String fileContent = readFileToString(buggyFIlePath);
		     
		     ASTParser parser = Parser.init(fileContent.toCharArray());
		     
		     CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);
		     List<MethodDeclaration> methodDeclarations = new MethodVisitor()
		    		 .findMethodDeclaration(compilationUnit);
		     
		     for(MethodDeclaration methodDeclaration: methodDeclarations) {
		    	 for (String buggyLineNo : bugPositionLineNumbers) {
		    		 //System.out.println(methodDeclaration.getName() + "\t" + buggyLineNo);
		    		 if(isBuggyMethod(compilationUnit, methodDeclaration, buggyLineNo)) {
		    			 if((buggyMethodList
		    					 .stream()
		    					 .anyMatch(e -> e.projectName.equals(project) && e.methodName.equals(methodDeclaration.getName().toString())))) {
			    			 //buggyMethodList.add(bm);
		    				 //System.out.println("skipped");
			    		 } else {
			    			 BuggyMethod bm  = new BuggyMethod();
				    		 bm.compilationUnit = compilationUnit;
				    		 bm.methodDeclaration = methodDeclaration;
				    		 
				    		 bm.faultyLineNo = Integer.parseInt(buggyLineNo);
				    		 bm.methodName = methodDeclaration.getName().toString();
				    		 bm.projectName = project;
				    		 bm.filePath = buggyFIlePath;
				    		 bm.startLine = compilationUnit
				    				 .getLineNumber(methodDeclaration.getStartPosition());
				    		 bm.endLine = compilationUnit
				    				 .getLineNumber(methodDeclaration.getStartPosition() + methodDeclaration.getLength());
				    		 
				    		 buggyMethodList.add(bm);
			    		 }	
			    		 
			    	 }
		    	 }

		     }
		     currentLine = reader.readLine();

	     }
	     reader.close();
	     
	}
	
	public String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(100000);
		try{		
			BufferedReader reader = new BufferedReader(new FileReader(filePath));

			char[] buffer = new char[10];
			int numRead = 0;
			while ((numRead = reader.read(buffer)) != -1) {
				String readData = String.valueOf(buffer, 0, numRead);
				fileData.append(readData);
				buffer = new char[1024];
			}

			reader.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return  fileData.toString();	
	}
	
	public boolean isBuggyMethod(CompilationUnit compilationUnit, MethodDeclaration mDec, String BugLineNo) {
		int lineNo = Integer.parseInt(BugLineNo);
		int start = compilationUnit.getLineNumber(mDec.getStartPosition());
		int end = compilationUnit.getLineNumber(mDec.getStartPosition() + mDec.getLength());
		//System.out.println(start + "\t" + end + "\t" + lineNo);
		if(lineNo >= start && lineNo <= end) {
			return true;
		}
		else return false;
	}
	
	public List<BuggyMethod> getBuggyMethodList() throws IOException {
		filter();
		return buggyMethodList;
	}
	
	private void filter() throws IOException{
		BufferedReader reader;
		var projects = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(Constants.fixedBugProjectsFilePath));
			String currentLine = reader.readLine();
			while(currentLine != null) {
				projects.add(currentLine);
				currentLine = reader.readLine();
			}
			reader.close();
			
			for (Iterator<BuggyMethod> iter = buggyMethodList.iterator(); iter.hasNext(); ) {
				  BuggyMethod element = iter.next();
				  //System.out.println(element.projectName);
				  if (!projects.contains(element.projectName)) {
				    iter.remove();
				  }
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}

}
