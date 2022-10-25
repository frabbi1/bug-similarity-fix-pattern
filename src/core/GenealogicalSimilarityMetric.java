package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.Statement;

import ModelBugSim.BuggyMethod;
import utility.CSVWriter;
import utility.FaultyNodeCollector;

public class GenealogicalSimilarityMetric {
	private List<String[]> dataToWrite = new ArrayList<String[]>();
	public GenealogicalSimilarityMetric() {
		
	}
	
	public void run(List<BuggyMethod> bMethods) throws IOException {
		FaultyNodeCollector faultyNodecollector = new FaultyNodeCollector(bMethods);
		
		for (BuggyMethod buggyMethod : bMethods) {
			var cu  = buggyMethod.compilationUnit;
			cu.accept(faultyNodecollector);
		}
		
		var buggyMethods = faultyNodecollector.getBuggyMethodsWithFaultyNodes();
		
		for (BuggyMethod buggyMethod : buggyMethods) {
			System.out.println(buggyMethod.methodName + " " + buggyMethod.faultyLineNo);
			buggyMethod.faultyNode.genealogy = getGenealogyContext(buggyMethod.faultyNode.node);
			break;
//			System.out.println();
		}
		
//		String[] headers = new String[buggyMethods.size()+1];
//		for(int i=0; i<buggyMethods.size()+1; i++) {
//			if(i==0) headers[i] = "#";
//			else {
//				headers[i] = buggyMethods.get(i-1).projectName;
//			}
//		}
//		dataToWrite.add(headers);
//		for (BuggyMethod bm1 : buggyMethods) {
//			String[] data = new String[buggyMethods.size()+1];
//			data[0] = bm1.projectName;
//			int idx = 1;
//			for (BuggyMethod bm2 : buggyMethods) {
//				data[idx] = String.valueOf(getGenealogySimilarityScore(bm1.faultyNode.genealogy, bm2.faultyNode.genealogy));
//				System.out.println(bm1.projectName + "--" + bm2.projectName + "--" + data[idx]);
//				idx++;
//			}
//			dataToWrite.add(data);
//		}
//		
//		new CSVWriter().Write(dataToWrite);
	}
	
	public HashMap<Integer,Integer> getGenealogyContext(ASTNode node) {		
		HashMap<Integer,Integer> genealogy = new HashMap<Integer,Integer>();

		ASTNode currentNode = node.getParent();
		while(currentNode!= null && currentNode.getNodeType()!=ASTNode.METHOD_DECLARATION) {
			if(currentNode.getNodeType()!=ASTNode.BLOCK) {
				System.out.println(currentNode.toString().replaceAll("[\\t\\n\\r,]+"," ") + " ");
				int type = currentNode.getNodeType();//
				if(genealogy.containsKey(type)) {
					genealogy.put(type, genealogy.get(type)+1);
				}
				else {
					genealogy.put(type, 1);
				}
			}
			currentNode = currentNode.getParent();
		}
		currentNode = node.getParent();
		while(currentNode!= null && currentNode.getNodeType()!=ASTNode.BLOCK) {
			currentNode = currentNode.getParent();
		}
		
		if(currentNode!= null) {
			currentNode.accept(new ASTVisitor() {
				@Override
				public void preVisit(ASTNode child) {
//					if(child.equals(temporaryNode)) {
//												System.out.println("SAME SAME");
						//						System.out.println(node);
//						return;
//					}
					
					if(child instanceof Expression) {
						int type = child.getNodeType();
						System.out.println(child.toString().replaceAll("[\\t\\n\\r,]+"," ") + " ");
						if(genealogy.containsKey(type)) {
							genealogy.put(type, genealogy.get(type)+1);
						}
						else {
							genealogy.put(type, 1);
						}
					}

					else if(child instanceof Statement) {
						int type = child.getNodeType();
						System.out.println(child.toString().replaceAll("[\\t\\n\\r,]+"," ") + " ");
						if(type==ASTNode.BLOCK) {
							return;
						}
						else if(genealogy.containsKey(type)) {
							genealogy.put(type, genealogy.get(type)+1);
						}
						else {
							genealogy.put(type, 1);
						}
					}
				}
			});
		}

		return genealogy;
	}
	
	public double getGenealogySimilarityScore(HashMap<Integer,Integer>genealogyTarget, HashMap<Integer,Integer>genealogySource) {
		double total1 = 0;
		double total2 = 0;
		if(genealogyTarget.isEmpty() || genealogySource.isEmpty()) {
			return total1;
		}
		HashSet<Integer> commonKeys = new HashSet<Integer>(genealogyTarget.keySet());
		commonKeys.retainAll(genealogySource.keySet());

		Iterator<Integer> iterator = commonKeys.iterator();  
		while(iterator.hasNext()){  
			Integer type = iterator.next();
//			System.out.println(type+ ": "+genealogyTarget.get(type) + " " +genealogySource.get(type));
			total1 = total1 + Integer.min(genealogyTarget.get(type), genealogySource.get(type));
		}
		
		HashSet<Integer> targetKeys = new HashSet<Integer>(genealogyTarget.keySet());
		iterator = targetKeys.iterator();  
		while(iterator.hasNext()) {  
			Integer type = iterator.next();
//			System.out.println(type + " "+genealogyTarget.get(type));
			total2 = total2 + genealogyTarget.get(type);
		}
		
		//		System.out.println(genealogyTarget.size());

		return total1/total2;
	}

}
