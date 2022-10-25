package core;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;

import ModelBugSim.BuggyMethod;
import edu.emory.mathcs.backport.java.util.Arrays;
import utility.NodeTypeCollector;

public class CosineSimilarityMetric {
	int numberONodes = 85;
	public CosineSimilarityMetric() {
		// TODO Auto-generated constructor stub
	}
	
	public void run(List<BuggyMethod> buggyMethods) {
		Map<String, int[]> bugVectorMap = new LinkedHashMap<String,int[]>();
		for (BuggyMethod buggyMethod : buggyMethods) {
			var vector = collectNodes(buggyMethod);
			bugVectorMap.put(buggyMethod.projectName, vector);
		}
		
		writeInFile(bugVectorMap);
	}


	private void writeInFile(Map<String, int[]> bugVectorMap) {
		try{    
	           FileWriter fw=new FileWriter("output/cosine_vector.csv");
	           for (Map.Entry<String, int[]> entry : bugVectorMap.entrySet()) {
	        	   String txt = entry.getKey() + ",";
	        	   String result = IntStream.of(entry.getValue())
	                         .mapToObj(Integer::toString)
	                         .collect(Collectors.joining(","));
	        	   fw.write(txt + result + "\n");
	        	    //System.out.println(entry.getKey() + ":" + entry.getValue().toString());
	        	}
	             
	           fw.close();
	          }catch(Exception e){System.out.println(e);}
		
	}

	public int[] collectNodes(BuggyMethod buggyMethod) {
		System.out.println(buggyMethod.projectName);
		var currentNode = buggyMethod.methodDeclaration;
		int[] nodeVector = new int[numberONodes];
		Arrays.fill(nodeVector, 0);
		//List<Integer> nodeVector = new ArrayList<Integer>(Collections.nCopies(numberONodes, 0));
		currentNode.accept(new ASTVisitor() {
			@Override
			public void preVisit(ASTNode child) {
				if(!(child.getNodeType()==ASTNode.METHOD_DECLARATION || NodeTypeCollector.getNodeType(child).equals(""))) {
					nodeVector[child.getNodeType() - 1] = nodeVector[child.getNodeType() - 1] + 1;
				}
			}
		});
		return nodeVector;
	}

}
