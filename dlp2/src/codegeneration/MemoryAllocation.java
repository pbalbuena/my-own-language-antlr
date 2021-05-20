/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.*;
import visitor.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

    /*
    * Poner aquí los visit.
    *
    * Si se ha usado VGen, solo hay que copiarlos de la clase 'visitor/_PlantillaParaVisitors.txt'.
    */

    // public Object visit(Program prog, Object param) {
    //      ...
    // }

	
//	class Program { List<Definition> definitions; }
	public Object visit(Program node, Object param) {

		// super.visit(node, param);
		
		int currentAddress = 0;
		
		if (node.getDefinitions() != null)
			for (Definition child : node.getDefinitions()) {
				//variables globales
				if(child instanceof VarDefinition) {
					((VarDefinition) child).setAddress(currentAddress);
					currentAddress += ((VarDefinition) child).getType().getSize();
				}
				child.accept(this, param);
			}
				
		return null;
	}
	
//	class StructDef { String name;  Type tipo;  List<Definition> records; }
	public Object visit(StructDef node, Object param) {

		// super.visit(node, param);

		int currentAddress = 0;
		
		if (node.getRecords() != null)
			for (Definition child : node.getRecords()) {
				//campos de struct
				if(child instanceof RecordDef) {
					((RecordDef) child).setAddress(currentAddress);
					currentAddress += ((RecordDef) child).getTipo().getSize();
				}
				child.accept(this, param);
			}
				
		return null;
	}
	
//	class FunctionDef { String ident;  Type tipo;  List<Definition> localDefs;  List<Sentence> stats; }
	public Object visit(FunctionDef node, Object param) {

		// super.visit(node, param);

		int currentAddress = 0;
		
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);

		if (node.getLocalDefs() != null)
			for (Definition child : node.getLocalDefs()) {
				//variables locales
				if(child instanceof VarDefinition) {
					//asignamos el ambito a 1
					((VarDefinition) child).setAmbito(1); //ambito 1 -> variable local
					//lo restamos
					int localSize = ((VarDefinition) child).getType().getSize();
					((VarDefinition) child).setAddress(currentAddress - localSize);
					currentAddress -= localSize;
				}
				child.accept(this, param);
			}
		if (node.getStats() != null)
			for (Sentence child : node.getStats())
				child.accept(this, param);

		return null;
	}
	
//	class FunctionType { Type retType;  List<Definition> paramDefs; }
	public Object visit(FunctionType node, Object param) {

		// super.visit(node, param);

		//sin retorno? current=4?
		int currentAddress = 4;
		
		if (node.getRetType() != null)
			node.getRetType().accept(this, param);

		if (node.getParamDefs() != null) {
			//parametros recorrer todos primero
			for (Definition child : node.getParamDefs()) {
				if(child instanceof VarDefinition) {
					((VarDefinition) child).setAmbito(2); //ambito 2 -> variable parametro
					currentAddress += ((VarDefinition) child).getType().getSize();
				}			
				child.accept(this, param);
			}
			//parametros asignar sus address
			for(Definition parametro : node.getParamDefs()) {
				if(parametro instanceof VarDefinition) {
					currentAddress -= ((VarDefinition) parametro).getType().getSize();
					((VarDefinition) parametro).setAddress(currentAddress);				
				}
			}
		}
		return null;
	}
	
//	class Indexing { Expression ident;  Expression index; }
	public Object visit(Indexing node, Object param) {

		// super.visit(node, param);

		if (node.getIdent() != null)
			node.getIdent().accept(this, param);

		if (node.getIndex() != null)
			node.getIndex().accept(this, param);

		
		return null;
	}
}
