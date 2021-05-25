/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	realConstant:expression -> value:float

public class RealConstant extends AbstractExpression {

	public RealConstant(float value) {
		this.value = value;
	}

	public RealConstant(Object value) {
		this.value = (value instanceof Token) ? Float.parseFloat(((Token)value).getText()) : (Float) value;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(value);
	}

	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private float value;

	public String toString() {
       return "{value:" + getValue() + "}";
   }
}
