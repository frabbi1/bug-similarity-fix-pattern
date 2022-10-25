package utility;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;

import ModelBugSim.BuggyMethod;
import ModelBugSim.FaultyNode;

public class FaultyNodeCollector extends ASTVisitor{
	
	private List<BuggyMethod> buggyMethods = new ArrayList<BuggyMethod>();
	
	public FaultyNodeCollector(List<BuggyMethod> buggyMethods) {
		this.buggyMethods  = buggyMethods;
	}
	@Override
	public void preVisit(ASTNode node) {
		this.collectFaultyNodes(node);
//		if(node instanceof Expression) {
//			this.collectFaultyNodes(node);
//		}
	}
	public List<BuggyMethod> getBuggyMethodsWithFaultyNodes(){
		return buggyMethods;
	}

	private void collectFaultyNodes(ASTNode node) {
		for (BuggyMethod buggyMethod : buggyMethods) {
			var cu = buggyMethod.compilationUnit;
			var faultyLine = buggyMethod.faultyLineNo;
			var currentNodeStartLine = cu.getLineNumber(node.getStartPosition());
			var currentNodeEndLine = cu.getLineNumber(node.getStartPosition() + node.getLength());
			if(faultyLine >= currentNodeStartLine && faultyLine <= currentNodeEndLine) {
				FaultyNode faultyNode = new FaultyNode();
				faultyNode.node = node;
				faultyNode.startLine = currentNodeStartLine;
				faultyNode.endLine = currentNodeEndLine;
				faultyNode.type = NodeTypeCollector.getNodeType(node);
				buggyMethod.faultyNode = faultyNode;
			}
		}
		
	}
}
