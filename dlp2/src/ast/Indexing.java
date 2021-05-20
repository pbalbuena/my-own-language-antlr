/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	indexing:expression -> ident:expression  index:expression

public class Indexing extends AbstractExpression {

	public Indexing(Expression ident, Expression index) {
		this.ident = ident;
		this.index = index;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(ident, index);
	}

	public Indexing(Object ident, Object index) {
		this.ident = (Expression) getAST(ident);
		this.index = (Expression) getAST(index);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(ident, index);
	}

	public Expression getIdent() {
		return ident;
	}
	public void setIdent(Expression ident) {
		this.ident = ident;
	}

	public Expression getIndex() {
		return index;
	}
	public void setIndex(Expression index) {
		this.index = index;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression ident;
	private Expression index;

	public String toString() {
       return "{ident:" + getIdent() + ", index:" + getIndex() + "}";
   }
}
