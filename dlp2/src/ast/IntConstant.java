/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	intConstant:expression -> value:int

public class IntConstant extends AbstractExpression {

	public IntConstant(int value) {
		this.value = value;
	}

	public IntConstant(Object value) {
		this.value = (value instanceof Token) ? Integer.parseInt(((Token)value).getText()) : (Integer) value;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(value);
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private int value;

	public String toString() {
       return "{value:" + getValue() + "}";
   }
}
