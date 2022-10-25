package ModelBugSim;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.jdt.core.dom.ASTNode;

public class FaultyNode {
	public ASTNode node;
	//double suspiciousValue;
	public int startLine;
	public int endLine;
	public String type;
	public HashMap<Integer,Integer>genealogy;
	//HashSet<Variable> variableAccessed;
	public HashMap<String,Integer> tokens;
	
	public FaultyNode() {
		this.genealogy = null;
		this.tokens = null;
	}
	
	@Override
	public String toString() {
		return "FaultyNode [node=" + node + ", startLine=" + startLine
				+ ", endLine=" + endLine + ", type=" + type + "]";
	}
}
