/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program node, Object param);
	public Object visit(VarDefinition node, Object param);
	public Object visit(FunctionDef node, Object param);
	public Object visit(StructDef node, Object param);
	public Object visit(RecordDef node, Object param);
	public Object visit(ArrayType node, Object param);
	public Object visit(StructType node, Object param);
	public Object visit(FunctionType node, Object param);
	public Object visit(CharType node, Object param);
	public Object visit(IntType node, Object param);
	public Object visit(RealType node, Object param);
	public Object visit(Print node, Object param);
	public Object visit(Read node, Object param);
	public Object visit(Assignment node, Object param);
	public Object visit(IfElse node, Object param);
	public Object visit(While node, Object param);
	public Object visit(Return node, Object param);
	public Object visit(CallProcedure node, Object param);
	public Object visit(Arithmetic node, Object param);
	public Object visit(Logic node, Object param);
	public Object visit(Comparison node, Object param);
	public Object visit(Variable node, Object param);
	public Object visit(Indexing node, Object param);
	public Object visit(Not node, Object param);
	public Object visit(UnaryMinus node, Object param);
	public Object visit(Cast node, Object param);
	public Object visit(FieldAccess node, Object param);
	public Object visit(CallFunction node, Object param);
	public Object visit(CharConstant node, Object param);
	public Object visit(IntConstant node, Object param);
	public Object visit(RealConstant node, Object param);
}
