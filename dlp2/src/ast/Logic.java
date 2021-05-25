/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	logic:expression -> left:expression  op:String  right:expression

public class Logic extends AbstractExpression {

	public Logic(Expression left, String op, Expression right) {
		this.left = left;
		this.op = op;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public Logic(Object left, Object op, Object right) {
		this.left = (Expression) getAST(left);
		this.op = (op instanceof Token) ? ((Token)op).getText() : (String) op;
		this.right = (Expression) getAST(right);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, op, right);
	}

	public Expression getLeft() {
		return left;
	}
	public void setLeft(Expression left) {
		this.left = left;
	}

	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}

	public Expression getRight() {
		return right;
	}
	public void setRight(Expression right) {
		this.right = right;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression left;
	private String op;
	private Expression right;

	public String toString() {
       return "{left:" + getLeft() + ", op:" + getOp() + ", right:" + getRight() + "}";
   }
}
