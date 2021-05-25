/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import visitor.*;

//	structType:type -> 

public class StructType extends AbstractType {

	private Definition definicion;
	
	private String name;
	
	public StructType(String name) {
		this.name = name;
	}
	
	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{StructType}";
   }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Definition getDefinicion() {
		return definicion;
	}

	public void setDefinicion(Definition definicion) {
		this.definicion = definicion;
	}
	
	@Override
	public String getMAPLName() {
		return name;
	}

	@Override
	public int getSize() {
		int valor = 0;
		StructDef sdef = (StructDef) definicion;
		for(Definition d : sdef.getRecords()) {
			RecordDef rdef = (RecordDef) d;
			valor += rdef.getTipo().getSize();
		}
		return valor;
	}
	
	public RecordDef getRecordByName( String nombre ) {
		StructDef sdef = (StructDef) definicion;
		for(Definition d : sdef.getRecords()) {	
			RecordDef rdef = (RecordDef) d;
			if(nombre.equals(rdef.getName())) {
				return rdef;
			}	
		}
		return null;
	}
}
