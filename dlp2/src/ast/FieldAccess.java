/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	fieldAccess:expression -> ident:expression  fieldName:String

public class FieldAccess extends AbstractExpression {

	public FieldAccess(Expression ident, String fieldName) {
		this.ident = ident;
		this.fieldName = fieldName;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(ident);
	}

	public FieldAccess(Object ident, Object fieldName) {
		this.ident = (Expression) getAST(ident);
		this.fieldName = (fieldName instanceof Token) ? ((Token)fieldName).getText() : (String) fieldName;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(ident, fieldName);
	}

	public Expression getIdent() {
		return ident;
	}
	public void setIdent(Expression ident) {
		this.ident = ident;
	}

	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression ident;
	private String fieldName;

	public String toString() {
       return "{ident:" + getIdent() + ", fieldName:" + getFieldName() + "}";
   }
}
