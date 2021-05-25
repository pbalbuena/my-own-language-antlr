/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	functionType:type -> retType:type  paramDefs:definition*

public class FunctionType extends AbstractType {

	public FunctionType(Type retType, List<Definition> paramDefs) {
		this.retType = retType;
		this.paramDefs = paramDefs;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(retType, paramDefs);
	}

	public FunctionType(Object retType, Object paramDefs) {
		this.retType = (Type) getAST(retType);
		this.paramDefs = this.<Definition>getAstFromContexts(paramDefs);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(retType, paramDefs);
	}

	public Type getRetType() {
		return retType;
	}
	public void setRetType(Type retType) {
		this.retType = retType;
	}

	public List<Definition> getParamDefs() {
		return paramDefs;
	}
	public void setParamDefs(List<Definition> paramDefs) {
		this.paramDefs = paramDefs;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Type retType;
	private List<Definition> paramDefs;

	public String toString() {
       return "{retType:" + getRetType() + ", paramDefs:" + getParamDefs() + "}";
   }

	@Override
	public int getSize() {
		int bytes = 0;
		for (Definition definition : paramDefs) {
			if(definition instanceof VarDefinition)
			bytes += ((VarDefinition) definition).getType().getSize();
		}
		return bytes;
	}
}
