/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.Visitor;

//	return:sentence -> expr:expression

public class Return extends AbstractSentence {

	private FunctionDef functionDefinition;
	private Type tipoRetorno;
	
	
	public Return(Expression expr) {
		this.expr = expr;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr);
	}

	public Return(Object expr) {
		this.expr = (Expression) getAST(expr);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr);
	}

	public Expression getExpr() {
		return expr;
	}
	public void setExpr(Expression expr) {
		this.expr = expr;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expr;

	public String toString() {
       return "{expr:" + getExpr() + "}";
   }

	public Type getTipoRetorno() {
		return tipoRetorno;
	}

	public void setTipoRetorno(Type tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}

	public FunctionDef getFunctionDefinition() {
		return functionDefinition;
	}

	public void setFunctionDefinition(FunctionDef functionDefinition) {
		this.functionDefinition = functionDefinition;
	}
}
