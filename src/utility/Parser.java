package utility;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;

public class Parser {
	
	public static ASTParser init(char[] fileContent) {
		ASTParser parser = ASTParser.newParser(AST.JLS10);
		parser.setSource(fileContent);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		
		return parser;
	}

}
