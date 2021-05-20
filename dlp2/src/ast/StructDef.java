/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	structDef:definition -> name:String  records:definition*

public class StructDef extends AbstractDefinition {

	public StructDef(String name, List<Definition> records) {
		this.name = name;
		this.records = records;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(records);
	}

	public StructDef(Object name, Object records) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.records = this.<Definition>getAstFromContexts(records);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, records);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Definition> getRecords() {
		return records;
	}
	public void setRecords(List<Definition> records) {
		this.records = records;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Definition> records;

	public Type dot(String fieldName) {
        //buscar en la lista de fields uno con igual nombre que fieldname
        //si lo hay devolver su tipo sino null
        for (Definition r : records) {
        	RecordDef rdef = (RecordDef) r;
            if (rdef.getName().equals(fieldName))
                return rdef.getTipo();
        }
        return null;
    }
	
	public String toString() {
       return "{name:" + getName() + ", records:" + getRecords() + "}";
   }
}
