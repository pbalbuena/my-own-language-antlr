package semantic.symboltables;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import ast.Definition;

public class SymbolTable {
	Stack<Map<String,Definition>> pilaAmbitos =
			new Stack<Map<String, Definition>>();
	
	

	public SymbolTable() {
		set();
	}
	
	public void set() {
		pilaAmbitos.push(new HashMap<String, Definition>());
	}
	
	public void reset() {
		pilaAmbitos.pop();
	}
	
	public void insertar(String nombre, Definition vardef) {
		pilaAmbitos.peek().put(nombre, vardef);
	}
	
	public Definition busca(String nombre) {
		for (int i = pilaAmbitos.size()-1; i >=0; i--) {
			Map<String, Definition> ambito = pilaAmbitos.get(i);
			Definition def = ambito.get(nombre);
			if(def!=null) {
				return def;
			}
		}
		return null;
	}
	
	public Definition buscaActual(String nombre) {
		Definition def = pilaAmbitos.peek().get(nombre);
		if(def!=null) {
			return def;
		}
		return null;
	}
	
	
	public Stack<Map<String, Definition>> getPilaAmbitos() {
		return pilaAmbitos;
	}

	public void setPilaAmbitos(Stack<Map<String, Definition>> pilaAmbitos) {
		this.pilaAmbitos = pilaAmbitos;
	}
}
