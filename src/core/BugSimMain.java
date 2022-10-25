package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;

import ModelBugSim.BuggyMethod;
import utility.ListPrinter;
import utility.NodeTypeCollector;

public class BugSimMain {

	public static void main(String[] args) throws IOException {
		
		BuggyCodeExtractor extractor = new BuggyCodeExtractor();
		extractor.extract();
		var buggyMethods = extractor.getBuggyMethodList();
		
		//new CosineSimilarityMetric().run(buggyMethods);
		new GenealogicalSimilarityMetric().run(buggyMethods);
		//new StructuralTokenSimilarityMetric().run(buggyMethods);
		

		System.out.println("END!!!!!!!!");
	}

}
