/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;
import java.util.*;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

	//	class Program { List<Definition> definitions; }
	public Object visit(Program node, Object param) {
		visitChildren(node.getDefinitions(), param);
		return null;
	}

	//	class VarDefinition { Type type;  String name; }
	public Object visit(VarDefinition node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class FunctionDef { String ident;  Type tipo;  List<Definition> localDefs;  List<Sentence> stats; }
	public Object visit(FunctionDef node, Object param) {
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);
		visitChildren(node.getLocalDefs(), param);
		visitChildren(node.getStats(), param);
		return null;
	}

	//	class StructDef { String name;  Type tipo;  List<Definition> records; }
	public Object visit(StructDef node, Object param) {
		visitChildren(node.getRecords(), param);
		return null;
	}

	//	class RecordDef { String name;  Type tipo; }
	public Object visit(RecordDef node, Object param) {
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);
		return null;
	}

	//	class ArrayType { int length;  Type typeOf; }
	public Object visit(ArrayType node, Object param) {
		if (node.getTypeOf() != null)
			node.getTypeOf().accept(this, param);
		return null;
	}

	//	class StructType {  }
	public Object visit(StructType node, Object param) {
		return null;
	}

	//	class FunctionType { Type retType;  List<Definition> paramDefs; }
	public Object visit(FunctionType node, Object param) {
		if (node.getRetType() != null)
			node.getRetType().accept(this, param);
		visitChildren(node.getParamDefs(), param);
		return null;
	}

	//	class CharType {  }
	public Object visit(CharType node, Object param) {
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType node, Object param) {
		return null;
	}

	//	class RealType {  }
	public Object visit(RealType node, Object param) {
		return null;
	}

	//	class Print { Expression expression; }
	public Object visit(Print node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Read { Expression expression; }
	public Object visit(Read node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class IfElse { Expression condition;  List<Sentence> ifSentences;  List<Sentence> elseSentences; }
	public Object visit(IfElse node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getIfSentences(), param);
		visitChildren(node.getElseSentences(), param);
		return null;
	}

	//	class While { Expression condition;  List<Sentence> whileSentences; }
	public Object visit(While node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getWhileSentences(), param);
		return null;
	}

	//	class Return { Expression expr; }
	public Object visit(Return node, Object param) {
		if (node.getExpr() != null)
			node.getExpr().accept(this, param);
		return null;
	}

	//	class CallProcedure { String ident;  List<Expression> args; }
	public Object visit(CallProcedure node, Object param) {
		visitChildren(node.getArgs(), param);
		return null;
	}

	//	class Arithmetic { Expression left;  String op;  Expression right; }
	public Object visit(Arithmetic node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Logic { Expression left;  String op;  Expression right; }
	public Object visit(Logic node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Comparison { Expression left;  String op;  Expression right; }
	public Object visit(Comparison node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		return null;
	}

	//	class Indexing { Expression ident;  Expression index; }
	public Object visit(Indexing node, Object param) {
		if (node.getIdent() != null)
			node.getIdent().accept(this, param);
		if (node.getIndex() != null)
			node.getIndex().accept(this, param);
		return null;
	}

	//	class Not { Expression expr; }
	public Object visit(Not node, Object param) {
		if (node.getExpr() != null)
			node.getExpr().accept(this, param);
		return null;
	}

	//	class UnaryMinus { Expression expr; }
	public Object visit(UnaryMinus node, Object param) {
		if (node.getExpr() != null)
			node.getExpr().accept(this, param);
		return null;
	}

	//	class Cast { Type castType;  Expression expr; }
	public Object visit(Cast node, Object param) {
		if (node.getCastType() != null)
			node.getCastType().accept(this, param);
		if (node.getExpr() != null)
			node.getExpr().accept(this, param);
		return null;
	}

	//	class FieldAccess { Expression ident;  String fieldName; }
	public Object visit(FieldAccess node, Object param) {
		if (node.getIdent() != null)
			node.getIdent().accept(this, param);
		return null;
	}

	//	class CallFunction { String ident;  List<Expression> arguments; }
	public Object visit(CallFunction node, Object param) {
		visitChildren(node.getArguments(), param);
		return null;
	}

	//	class CharConstant { char value; }
	public Object visit(CharConstant node, Object param) {
		return null;
	}

	//	class IntConstant { int value; }
	public Object visit(IntConstant node, Object param) {
		return null;
	}

	//	class RealConstant { float value; }
	public Object visit(RealConstant node, Object param) {
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
