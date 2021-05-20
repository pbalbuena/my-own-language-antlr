/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	charConstant:expression -> value:char

public class CharConstant extends AbstractExpression {

	public CharConstant(char value) {
		this.value = value;
	}

	public CharConstant(Object value) {
		this.value = (value instanceof Token) ? ((Token)value).getText().charAt(0) : (Character) value;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(value);
	}

	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private char value;

	public String toString() {
       return "{value:" + getValue() + "}";
   }
}
