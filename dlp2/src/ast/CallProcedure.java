/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	callProcedure:sentence -> ident:String  args:expression*

public class CallProcedure extends AbstractSentence {

	private Definition definicion;
	
	public CallProcedure(String ident, List<Expression> args) {
		this.ident = ident;
		this.args = args;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(args);
	}

	public CallProcedure(Object ident, Object args) {
		this.ident = (ident instanceof Token) ? ((Token)ident).getText() : (String) ident;
		this.args = this.<Expression>getAstFromContexts(args);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(ident, args);
	}

	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}

	public List<Expression> getArgs() {
		return args;
	}
	public void setArgs(List<Expression> args) {
		this.args = args;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String ident;
	private List<Expression> args;

	public String toString() {
       return "{ident:" + getIdent() + ", args:" + getArgs() + "}";
   }

	public void setDefinicion(Definition definicion) {
		this.definicion = definicion;
	}

	public Definition getDefinicion() {
		return definicion;
	}
	
	
}
