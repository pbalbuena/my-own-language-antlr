/**
 * Tutorial de DiseÃ±o de Lenguajes de ProgramaciÃ³n
 * @author RaÃºl Izquierdo
 */

package semantic;

import ast.AST;
import ast.CallFunction;
import ast.CallProcedure;
import ast.Definition;
import ast.Expression;
import ast.FunctionDef;
import ast.Position;
import ast.RecordDef;
import ast.Return;
import ast.Sentence;
import ast.StructDef;
import ast.StructType;
import ast.VarDefinition;
import ast.Variable;
import main.ErrorManager;
import semantic.symboltables.SymbolTable;
import visitor.DefaultVisitor;

public class Identification extends DefaultVisitor {

	private SymbolTable variables = new SymbolTable();
	private SymbolTable funciones = new SymbolTable();
	private SymbolTable structs = new SymbolTable();
	private SymbolTable recordDefs = new SymbolTable();

	public Identification(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	// # ----------------------------------------------------------
	/*
	 * Poner aqui los visit.
	 *
	 * Si se ha usado VGen, solo hay que copiarlos de la clase
	 * 'visitor/_PlantillaParaVisitors.txt'.
	 */

	// class VarDefinition { Type type; String name; }

	public Object visit(VarDefinition node, Object param) {
		Definition definicion = variables.buscaActual(node.getName());
		predicado(definicion == null, "Variable ya definida: " + node.getName(), node);
		
		node.getType().accept(this, param); // No es necesario realmente
		
		variables.insertar(node.getName(), node);
		
		return null;
	}
	
//	class StructType {  }
	public Object visit(StructType node, Object param) {
		Definition definicion = structs.busca(node.getName());
		predicado(definicion != null, "Tipo struct no definida: " + node.getName(), node);
		node.setDefinicion(definicion);//enlazamos referencias 
		return null;
	}

	// class Variable { String name; }
	public Object visit(Variable node, Object param) {
		Definition definicion = variables.busca(node.getName());
		predicado(definicion != null, "Variable no definida: " + node.getName(), node);
		node.setDefinicion(definicion); // Enlazar referencia con definición
		return null;
	}

	// class FunctionDef { String ident; Type tipo; List<Definition> localDefs;
	// List<Sentence> stats; }
	public Object visit(FunctionDef node, Object param) {
		
		predicado(funciones.busca(node.getIdent()) == null, "Función ya definida: " + node.getIdent(), node);
		funciones.insertar(node.getIdent(), node);
		// subimos el ambito de las variables
		variables.set();
		if (node.getTipo() != null) {
			node.getTipo().accept(this, param);
		}
		if (node.getLocalDefs() != null) {
			for (Definition d : node.getLocalDefs()) {
				d.accept(this, param);
			}
		}
		if (node.getStats() != null) {
			for (Sentence s : node.getStats()) {
				s.accept(this, param);
				if(s instanceof Return) {
					((Return) s).setFunctionDefinition(node);
				}
			}
		}
		variables.reset();
		return null;
	}

//	class CallFunction { String ident;  List<Expression> arguments; }
	public Object visit(CallFunction node, Object param) {

		// super.visit(node, param);

		Definition definicion = funciones.busca(node.getIdent());
		predicado(definicion != null, "Función no definida: " + node.getIdent(), node);
		node.setDefinicion(definicion); // Enlazar referencia con definición
		
		if (node.getArguments() != null)
			for (Expression child : node.getArguments())
				child.accept(this, param);

		return null;
	}
	
//	class CallProcedure { String ident;  List<Expression> args; }
	public Object visit(CallProcedure node, Object param) {

		// super.visit(node, param);

		Definition definicion = funciones.busca(node.getIdent());
		predicado(definicion != null, "Procedimiento no definido: " + node.getIdent(), node);
		node.setDefinicion(definicion); // Enlazar referencia con definición
		
		if (node.getArgs() != null)
			for (Expression child : node.getArgs())
				child.accept(this, param);

		return null;
	}

//	class StructDef { String name;  Type tipo;  List<Definition> records; }
	public Object visit(StructDef node, Object param) {

		// super.visit(node, param);

		predicado(structs.busca(node.getName()) == null, "Struct ya definida: " + node.getName(), node);
		structs.insertar(node.getName(), node);
		
		recordDefs.set();
		

		if (node.getRecords() != null)
			for (Definition child : node.getRecords())
				child.accept(this, param);

		recordDefs.reset();
		
		return null;
	}
	
//	class RecordDef { String name;  Type tipo; }
	public Object visit(RecordDef node, Object param) {

		// super.visit(node, param);

		Definition definicion = recordDefs.busca(node.getName());
		predicado(definicion == null, "Record Def ya definido: " + node.getName(), node);
		recordDefs.insertar(node.getName(), node);
	
		
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);

		return null;
	}

	// # --------------------------------------------------------
	// Metodos auxiliares recomendados (opcionales) -------------

	@SuppressWarnings("unused")
	private void error(String msg) {
		error(msg, null);
	}

	private void error(String msg, Position position) {
		errorManager.notify("Identification", msg, position);
	}

	private void predicado(boolean condition, String errorMessage, AST node) {
		if (!condition)
			error(errorMessage, node.getStart());
	}

	private ErrorManager errorManager;
}
