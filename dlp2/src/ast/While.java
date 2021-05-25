/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	while:sentence -> condition:expression  whileSentences:sentence*

public class While extends AbstractSentence {

	public While(Expression condition, List<Sentence> whileSentences) {
		this.condition = condition;
		this.whileSentences = whileSentences;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, whileSentences);
	}

	public While(Object condition, Object whileSentences) {
		this.condition = (Expression) getAST(condition);
		this.whileSentences = this.<Sentence>getAstFromContexts(whileSentences);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, whileSentences);
	}

	public Expression getCondition() {
		return condition;
	}
	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	public List<Sentence> getWhileSentences() {
		return whileSentences;
	}
	public void setWhileSentences(List<Sentence> whileSentences) {
		this.whileSentences = whileSentences;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression condition;
	private List<Sentence> whileSentences;

	public String toString() {
       return "{condition:" + getCondition() + ", whileSentences:" + getWhileSentences() + "}";
   }
}
