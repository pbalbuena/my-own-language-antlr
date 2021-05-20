/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	functionDef:definition -> ident:String  tipo:type  localDefs:definition*  stats:sentence*

public class FunctionDef extends AbstractDefinition {

	public FunctionDef(String ident, Type tipo, List<Definition> localDefs, List<Sentence> stats) {
		this.ident = ident;
		this.tipo = tipo;
		this.localDefs = localDefs;
		this.stats = stats;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo, localDefs, stats);
	}

	public FunctionDef(Object ident, Object tipo, Object localDefs, Object stats) {
		this.ident = (ident instanceof Token) ? ((Token)ident).getText() : (String) ident;
		this.tipo = (Type) getAST(tipo);
		this.localDefs = this.<Definition>getAstFromContexts(localDefs);
		this.stats = this.<Sentence>getAstFromContexts(stats);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(ident, tipo, localDefs, stats);
	}

	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}

	public Type getTipo() {
		return tipo;
	}
	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}

	public List<Definition> getLocalDefs() {
		return localDefs;
	}
	public void setLocalDefs(List<Definition> localDefs) {
		this.localDefs = localDefs;
	}

	public List<Sentence> getStats() {
		return stats;
	}
	public void setStats(List<Sentence> stats) {
		this.stats = stats;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String ident;
	private Type tipo;
	private List<Definition> localDefs;
	private List<Sentence> stats;

	public String toString() {
       return "{ident:" + getIdent() + ", tipo:" + getTipo() + ", localDefs:" + getLocalDefs() + ", stats:" + getStats() + "}";
   }
	
	public int getLocalBytes() {
		int total = 0;
		for (Definition definition : localDefs) {
			VarDefinition vdef = (VarDefinition) definition;
			total += vdef.getType().getSize();
		}
		return total;
	}
}
