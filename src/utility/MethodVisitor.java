package utility;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class MethodVisitor extends ASTVisitor {
	List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	
	@Override
	public boolean visit(MethodDeclaration node) {
		methods.add(node);
		return super.visit(node);
	}
	
	public List<MethodDeclaration> getMethods() {
        return methods;
    }
	
	public List<MethodDeclaration> findMethodDeclaration(ASTNode node) {
		MethodVisitor finder =  new MethodVisitor();
		node.accept(finder);
        return finder.getMethods();
    } 

}
