package utility;

import org.eclipse.jdt.core.dom.ASTNode;

public class NodeTypeCollector {
	public static String getNodeType(ASTNode node) {
		if(node.getNodeType()==ASTNode.ANNOTATION_TYPE_DECLARATION) {
			return "ANNOTATION_TYPE_DECLARATION";
		}
		if(node.getNodeType()==ASTNode.ANNOTATION_TYPE_MEMBER_DECLARATION) {
			return "ANNOTATION_TYPE_MEMBER_DECLARATION";
		}
				if(node.getNodeType()==ASTNode.ANONYMOUS_CLASS_DECLARATION) {
					return "ANONYMOUS_CLASS_DECLARATION";
				}
		if(node.getNodeType()==ASTNode.ARRAY_ACCESS) {
			return "ARRAY_ACCESS";
		}
		if(node.getNodeType()==ASTNode.ARRAY_CREATION) {
			return "ARRAY_CREATION";
		}
		if(node.getNodeType()==ASTNode.ARRAY_INITIALIZER) {
			return "ARRAY_INITIALIZER";
		}
		if(node.getNodeType()==ASTNode.ARRAY_TYPE) {
			return "ARRAY_TYPE";
		}
		if(node.getNodeType()==ASTNode.ASSERT_STATEMENT) {
			return "ASSERT_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.ASSIGNMENT) {
			return "ASSIGNMENT";
		}
		if(node.getNodeType()==ASTNode.BLOCK) {
			return "BLOCK";
		}
				if(node.getNodeType()==ASTNode.BLOCK_COMMENT) {
					return "ANNOTATION_TYPE_DECLARATION";
				}
		if(node.getNodeType()==ASTNode.BOOLEAN_LITERAL) {
			return "BOOLEAN_LITERAL";
		}
		if(node.getNodeType()==ASTNode.BREAK_STATEMENT) {
			return "BREAK_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.CAST_EXPRESSION) {
			return "CAST_EXPRESSION";
		}
		if(node.getNodeType()==ASTNode.CATCH_CLAUSE) {
			return "CATCH_CLAUSE";
		}
		if(node.getNodeType()==ASTNode.CHARACTER_LITERAL) {
			return "CHARACTER_LITERAL";
		}
		if(node.getNodeType()==ASTNode.CLASS_INSTANCE_CREATION) {
			return "CLASS_INSTANCE_CREATION";
		}
				if(node.getNodeType()==ASTNode.COMPILATION_UNIT) {
					return "COMPILATION_UNIT";
				}
		if(node.getNodeType()==ASTNode.CONDITIONAL_EXPRESSION) {
			return "CONDITIONAL_EXPRESSION";
		}
		if(node.getNodeType()==ASTNode.CONSTRUCTOR_INVOCATION) {
			return "CONSTRUCTOR_INVOCATION";
		}
		if(node.getNodeType()==ASTNode.CONTINUE_STATEMENT) {
			return "CONTINUE_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.CREATION_REFERENCE) {
			return "CREATION_REFERENCE";
		}
				if(node.getNodeType()==ASTNode.DIMENSION) {
					return "DIMENSION";
				}
		if(node.getNodeType()==ASTNode.DO_STATEMENT) {
			return "DO_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.ENHANCED_FOR_STATEMENT) {
			return "ENHANCED_FOR_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.ENUM_CONSTANT_DECLARATION) {
			return "ENUM_CONSTANT_DECLARATION";
		}
		if(node.getNodeType()==ASTNode.ENUM_DECLARATION) {
			return "ENUM_DECLARATION";
		}
		if(node.getNodeType()==ASTNode.EXPORTS_DIRECTIVE) {
			return "EXPORTS_DIRECTIVE";
		}
		if(node.getNodeType()==ASTNode.EXPRESSION_METHOD_REFERENCE) {
			return "EXPRESSION_METHOD_REFERENCE";
		}
		if(node.getNodeType()==ASTNode.EXPRESSION_STATEMENT) {
			return "EXPRESSION_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.FIELD_ACCESS) {
			return "FIELD_ACCESS";
		}
		if(node.getNodeType()==ASTNode.FIELD_DECLARATION) {
			return "FIELD_DECLARATION";
		}
		if(node.getNodeType()==ASTNode.FOR_STATEMENT) {
			return "FOR_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.IF_STATEMENT) {
			return "IF_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.INFIX_EXPRESSION) {
			return "INFIX_EXPRESSION";
		}
		if(node.getNodeType()==ASTNode.INITIALIZER) {
			return "INITIALIZER";
		}
		if(node.getNodeType()==ASTNode.INSTANCEOF_EXPRESSION) {
			return "INSTANCEOF_EXPRESSION";
		}
		if(node.getNodeType()==ASTNode.INTERSECTION_TYPE) {
			return "INTERSECTION_TYPE";
		}
		if(node.getNodeType()==ASTNode.LABELED_STATEMENT) {
			return "LABELED_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.LAMBDA_EXPRESSION) {
			return "LAMBDA_EXPRESSION";
		}
		if(node.getNodeType()==ASTNode.METHOD_DECLARATION) {
			return "METHOD_DECLARATION";
		}
		if(node.getNodeType()==ASTNode.METHOD_INVOCATION) {
			return "METHOD_INVOCATION";
		}
		if(node.getNodeType()==ASTNode.METHOD_REF) {
			return "METHOD_REF";
		}
		if(node.getNodeType()==ASTNode.METHOD_REF_PARAMETER) {
			return "METHOD_REF_PARAMETER";
		}
		if(node.getNodeType()==ASTNode.MODULE_DECLARATION) {
			return "MODULE_DECLARATION";
		}
		if(node.getNodeType()==ASTNode.NAME_QUALIFIED_TYPE) {
			return "NAME_QUALIFIED_TYPE";
		}
		if(node.getNodeType()==ASTNode.NULL_LITERAL) {
			return "NULL_LITERAL";
		}
		if(node.getNodeType()==ASTNode.NUMBER_LITERAL) {
			return "NUMBER_LITERAL";
		}
		if(node.getNodeType()==ASTNode.PARAMETERIZED_TYPE) {
			return "PARAMETERIZED_TYPE";
		}
		if(node.getNodeType()==ASTNode.PARENTHESIZED_EXPRESSION) {
			return "PARENTHESIZED_EXPRESSION";
		}
		if(node.getNodeType()==ASTNode.POSTFIX_EXPRESSION) {
			return "POSTFIX_EXPRESSION";
		}
		if(node.getNodeType()==ASTNode.PREFIX_EXPRESSION) {
			return "PREFIX_EXPRESSION";
		}
		if(node.getNodeType()==ASTNode.PRIMITIVE_TYPE) {
			return "PRIMITIVE_TYPE";
		}
		if(node.getNodeType()==ASTNode.QUALIFIED_NAME) {
			return "QUALIFIED_NAME";
		}
		if(node.getNodeType()==ASTNode.QUALIFIED_TYPE) {
			return "QUALIFIED_TYPE";
		}
		if(node.getNodeType()==ASTNode.RETURN_STATEMENT) {
			return "RETURN_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.SIMPLE_NAME) {
			return "SIMPLE_NAME";
		}
		if(node.getNodeType()==ASTNode.SIMPLE_TYPE) {
			return "SIMPLE_TYPE";
		}
		if(node.getNodeType()==ASTNode.SINGLE_VARIABLE_DECLARATION) {
			return "SINGLE_VARIABLE_DECLARATION";
		}
		if(node.getNodeType()==ASTNode.STRING_LITERAL) {
			return "STRING_LITERAL";
		}
		if(node.getNodeType()==ASTNode.SUPER_FIELD_ACCESS) {
			return "SUPER_FIELD_ACCESS";
		}
		if(node.getNodeType()==ASTNode.SUPER_METHOD_INVOCATION) {
			return "SUPER_METHOD_INVOCATION";
		}
		if(node.getNodeType()==ASTNode.SUPER_METHOD_REFERENCE) {
			return "SUPER_METHOD_REFERENCE";
		}
		if(node.getNodeType()==ASTNode.SUPER_CONSTRUCTOR_INVOCATION) {
			return "SUPER_CONSTRUCTOR_INVOCATION";
		}
		if(node.getNodeType()==ASTNode.SWITCH_CASE) {
			return "SWITCH_CASE";
		}
		if(node.getNodeType()==ASTNode.SWITCH_STATEMENT) {
			return "SWITCH_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.SYNCHRONIZED_STATEMENT) {
			return "SYNCHRONIZED_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.TAG_ELEMENT) {
			return "TAG_ELEMENT";
		}
		if(node.getNodeType()==ASTNode.TEXT_ELEMENT) {
			return "TEXT_ELEMENT";
		}
		if(node.getNodeType()==ASTNode.THIS_EXPRESSION) {
			return "THIS_EXPRESSION";
		}
		if(node.getNodeType()==ASTNode.THROW_STATEMENT) {
			return "THROW_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.TRY_STATEMENT) {
			return "TRY_STATEMENT";
		}
				if(node.getNodeType()==ASTNode.TYPE_DECLARATION) {
					return "TYPE_DECLARATION";
				}
		if(node.getNodeType()==ASTNode.TYPE_DECLARATION_STATEMENT) {
			System.out.println("TYPE_DECLARATION_STATEMENT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+node.toString());
			return "TYPE_DECLARATION_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.TYPE_LITERAL) {
			return "TYPE_LITERAL";
		}
		if(node.getNodeType()==ASTNode.TYPE_METHOD_REFERENCE) {
			return "TYPE_METHOD_REFERENCE";
		}
		if(node.getNodeType()==ASTNode.TYPE_PARAMETER) {
			return "TYPE_PARAMETER";
		}
		if(node.getNodeType()==ASTNode.UNION_TYPE) {
			return "UNION_TYPE";
		}
		if(node.getNodeType()==ASTNode.USES_DIRECTIVE) {
			return "USES_DIRECTIVE";
		}
		if(node.getNodeType()==ASTNode.VARIABLE_DECLARATION_EXPRESSION) {
			return "VARIABLE_DECLARATION_EXPRESSION";
		}
		if(node.getNodeType()==ASTNode.VARIABLE_DECLARATION_FRAGMENT) {
			return "VARIABLE_DECLARATION_FRAGMENT";
		}
		if(node.getNodeType()==ASTNode.VARIABLE_DECLARATION_STATEMENT) {
			return "VARIABLE_DECLARATION_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.WHILE_STATEMENT) {
			return "WHILE_STATEMENT";
		}
		if(node.getNodeType()==ASTNode.WILDCARD_TYPE) {
			return "WILDCARD_TYPE";
		}
		return "";
	}

}
