/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	callFunction:expression -> ident:String  arguments:expression*

public class CallFunction extends AbstractExpression {

	private Definition definicion;
	
	public CallFunction(String ident, List<Expression> arguments) {
		this.ident = ident;
		this.arguments = arguments;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(arguments);
	}

	public CallFunction(Object ident, Object arguments) {
		this.ident = (ident instanceof Token) ? ((Token)ident).getText() : (String) ident;
		this.arguments = this.<Expression>getAstFromContexts(arguments);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(ident, arguments);
	}

	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}

	public List<Expression> getArguments() {
		return arguments;
	}
	public void setArguments(List<Expression> arguments) {
		this.arguments = arguments;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String ident;
	private List<Expression> arguments;

	public String toString() {
       return "{ident:" + getIdent() + ", arguments:" + getArguments() + "}";
   }

	public void setDefinicion(Definition definicion) {
		this.definicion = definicion;
	}

	public Definition getDefinicion() {
		return definicion;
	}
	
	
}
