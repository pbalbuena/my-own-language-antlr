/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	arrayType:type -> length:int  typeOf:type

public class ArrayType extends AbstractType {

	public ArrayType(int length, Type typeOf) {
		this.length = length;
		this.typeOf = typeOf;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(typeOf);
	}

	public ArrayType(Object length, Object typeOf) {
		this.length = (length instanceof Token) ? Integer.parseInt(((Token)length).getText()) : (Integer) length;
		this.typeOf = (Type) getAST(typeOf);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(length, typeOf);
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	public Type getTypeOf() {
		return typeOf;
	}
	public void setTypeOf(Type typeOf) {
		this.typeOf = typeOf;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private int length;
	private Type typeOf;

	public String toString() {
       return "{length:" + getLength() + ", typeOf:" + getTypeOf() + "}";
   }

	@Override
	public int getSize() {
		return length * typeOf.getSize();
	}
	
	@Override
	public String getMAPLName() {
		return length + " * " + typeOf.getMAPLName();
	}
}
