/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	print:sentence -> expression:expression

public class Print extends AbstractSentence {

	private int tipoPrint; //1 print 2 printsp 3 println
	
	public Print(Object expression, int tipoPrint) {
		this.expression = (Expression) getAST(expression);
		this.tipoPrint = tipoPrint; //1 print 2 printsp 3 println
		
       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}
	
	public Print(Expression expression) {
		this.expression = expression;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}

	public Print(Object expression) {
		this.expression = (Expression) getAST(expression);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}

	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expression;

	public String toString() {
       return "{expression:" + getExpression() + "}";
   }

	public int getTipoPrint() {
		return tipoPrint;
	}

	public void setTipoPrint(int tipoPrint) {
		this.tipoPrint = tipoPrint;
	}
}
