package ModelBugSim;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class BuggyMethod {
	public String methodName;
	public String projectName;
	public String filePath;
	public int startLine;
	public int endLine;
	public int faultyLineNo; //if multiple faulty line only first one considered.
	public FaultyNode faultyNode;
	
	public CompilationUnit compilationUnit;
	public MethodDeclaration methodDeclaration;

}
