/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	cast:expression -> castType:type  expr:expression

public class Cast extends AbstractExpression {

	public Cast(Type castType, Expression expr) {
		this.castType = castType;
		this.expr = expr;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(castType, expr);
	}

	public Cast(Object castType, Object expr) {
		this.castType = (Type) getAST(castType);
		this.expr = (Expression) getAST(expr);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(castType, expr);
	}

	public Type getCastType() {
		return castType;
	}
	public void setCastType(Type castType) {
		this.castType = castType;
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

	private Type castType;
	private Expression expr;

	public String toString() {
       return "{castType:" + getCastType() + ", expr:" + getExpr() + "}";
   }
}
