/**
 * Tutorial de DiseÃ±o de Lenguajes de ProgramaciÃ³n
 * @author RaÃºl Izquierdo
 */

package semantic;

import ast.*;
import main.*;
import visitor.*;

public class TypeChecking extends DefaultVisitor {

	public TypeChecking(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}	

	// # ----------------------------------------------------------
	/*
	 * Poner aquÃ­ los visit.
	 *
	 * Si se ha usado VGen, solo hay que copiarlos de la clase
	 * 'visitor/_PlantillaParaVisitors.txt'.
	 */
	
//	class FunctionDef { String ident;  Type tipo;  List<Definition> localDefs;  List<Sentence> stats; }
	public Object visit(FunctionDef node, Object param) {

		// super.visit(node, param);

		if (node.getTipo() != null)
			node.getTipo().accept(this, param);

		if (node.getLocalDefs() != null)
			for (Definition child : node.getLocalDefs())
				child.accept(this, param);

		if (node.getStats() != null) {
			for (Sentence child : node.getStats()) {
				if(child instanceof Return) {
					FunctionType tipoF = (FunctionType) node.getTipo();
					((Return) child).setTipoRetorno(tipoF.getRetType());
				}
				child.accept(this, param);
			}
		}
		return null;
	}


//	class Return { Expression expr; }
	public Object visit(Return node, Object param) {

		// super.visit(node, param);

		if (node.getExpr() != null)
			node.getExpr().accept(this, param);
		
		if(node.getExpr() != null) {
			predicado(mismoTipo(node.getExpr().getType(), node.getTipoRetorno()), 
					"RETURN: La expresión de retorno: " + node.getExpr().getType() 
					+ " no coincide con el tipo esperado: "+ node.getTipoRetorno().toString(), node);
		} 
		if(node.getExpr() == null){
			predicado(node.getTipoRetorno()==null, "RETURN: La expresión de retorno debe tener una expresión asignada", node);
		}	

		return null;
	}
	
//	class IfElse { Expression condition;  List<Sentence> ifSentences;  List<Sentence> elseSentences; }
	public Object visit(IfElse node, Object param) {

		// super.visit(node, param);

		if (node.getCondition() != null)
			node.getCondition().accept(this, param);

		if (node.getIfSentences() != null)
			for (Sentence child : node.getIfSentences())
				child.accept(this, param);

		if (node.getElseSentences() != null)
			for (Sentence child : node.getElseSentences())
				child.accept(this, param);
		
		if(node.getCondition().getType() != null) {
			predicado(node.getCondition().getType().getClass().equals(IntType.class),
					"IF ELSE: La condición espera un tipo: " + IntType.class.getSimpleName() +
					" pero se encontró: " + node.getCondition().getType(), node);
		}

		return null;
	}

	//	class While { Expression condition;  List<Sentence> whileSentences; }
	public Object visit(While node, Object param) {

		// super.visit(node, param);

		if (node.getCondition() != null)
			node.getCondition().accept(this, param);

		if (node.getWhileSentences() != null)
			for (Sentence child : node.getWhileSentences())
				child.accept(this, param);

		if(node.getCondition().getType() != null) {
			predicado(node.getCondition().getType().getClass().equals(IntType.class),
					"WHILE: La condición espera un tipo: " + IntType.class.getSimpleName() +
					" pero se encontró: " + node.getCondition().getType(), node);
		}
		
		return null;
	}
	
//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);
		
		predicado(esPrimitivo(node.getLeft().getType()), "ASIGNACIÓN: La expresión de la izquierda debe ser un tipo simple", node);
		predicado(node.getLeft().isModificable(), "ASIGNACIÓN: La expresión de la izquierda no es modificable", node);
		predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType()), 
				"ASIGNACIÓN: El tipo de la expresión es: " + node.getRight().getType().toString() +
				" pero se esperaba: " + node.getLeft().getType().toString(), node);

		return null;
	}
	
//	class Read { Expression expression; }
	public Object visit(Read node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		
		predicado(esPrimitivo(node.getExpression().getType()), "READ: La expresión debe ser un tipo simple", node);
		predicado(node.getExpression().isModificable(), "READ: La expresión no es modificable", node);

		return null;
	}
	
//	class Print { Expression expression; }
	public Object visit(Print node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		
		predicado(esPrimitivo(node.getExpression().getType()), "PRINT: La expresión debe ser un tipo simple", node);	

		return null;
	}
	
//	class CallProcedure { String ident;  List<Expression> args; }
	public Object visit(CallProcedure node, Object param) {

		// super.visit(node, param);

		if (node.getArgs() != null)
			for (Expression child : node.getArgs())
				child.accept(this, param);

		checkParamsForCallProc(node);
		
		return null;
	}
	
//	class CallFunction { String ident;  List<Expression> arguments; }
	public Object visit(CallFunction node, Object param) {

		// super.visit(node, param);

		if (node.getArguments() != null)
			for (Expression child : node.getArguments())
				child.accept(this, param);

		checkParamsForCallFunction(node);
		FunctionDef fdef = (FunctionDef) node.getDefinicion();
		FunctionType ftype = (FunctionType) fdef.getTipo();
		node.setType(ftype.getRetType());
		node.setModificable(false);
		return null;
	}
	
//	class Arithmetic { Expression left;  String op;  Expression right; }
	public Object visit(Arithmetic node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		if(node.getLeft().getType() == null || node.getRight().getType()==null) {
			predicado(node.getLeft().getType() == null, 
					"ARITHMETIC: Esta función no retorna nada: " + node.getLeft().toString(), node);
			predicado(node.getRight().getType() == null, 
					"ARITHMETIC: Esta función no retorna nada: " + node.getRight().toString(), node);
		} else {
			predicado(esPrimitivo(node.getLeft().getType()) && esPrimitivo(node.getRight().getType()), "ARITHMETIC: El tipo de las expresiones debe ser primitivo", node);
			predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType()), 
					"ARITHMETIC: Las expresiones no son del mismo tipo", node);
		}
	
		node.setType(node.getLeft().getType());
		node.setModificable(false);
		
		return null;
	}
	
//	class Logic { Expression left;  String op;  Expression right; }
	public Object visit(Logic node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		if(node.getLeft().getType() == null || node.getRight().getType()==null) {
			predicado(node.getLeft().getType() == null, 
					"LOGIC: Esta función no retorna nada: " + node.getLeft().toString(), node);
			predicado(node.getRight().getType() == null, 
					"LOGIC: Esta función no retorna nada: " + node.getRight().toString(), node);
		} else {
			predicado(node.getLeft().getType().getClass()==IntType.class && node.getRight().getType().getClass()==IntType.class, 
			"LOGIC: El tipo de las expresiones debe ser int", node);
		}
	
		node.setType(new IntType());
		node.setModificable(false);
		
		return null;
	}
	
//	class Comparison { Expression left;  String op;  Expression right; }
	public Object visit(Comparison node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);
		
		if(node.getLeft().getType() == null || node.getRight().getType()==null) {
			predicado(node.getLeft().getType() == null, 
					"COMPARISON: Esta función no retorna nada: " + node.getLeft().toString(), node);
			predicado(node.getRight().getType() == null, 
					"COMPARISON: Esta función no retorna nada: " + node.getRight().toString(), node);
		} else {
			predicado(esPrimitivo(node.getLeft().getType()) && esPrimitivo(node.getRight().getType()), "COMPARISON: El tipo de las expresiones debe ser primitivo", node);
			predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType()), 
					"COMPARISON: Las expresiones no son del mismo tipo", node);
		}
	
		node.setType(new IntType());
		node.setModificable(false);
		
		return null;
	}
	
//	class Cast { Type castType;  Expression expr; }
	public Object visit(Cast node, Object param) {

		// super.visit(node, param);

		if (node.getCastType() != null)
			node.getCastType().accept(this, param);

		if (node.getExpr() != null)
			node.getExpr().accept(this, param);

		predicado(esCasteable(node.getExpr().getType(), node.getCastType()), 
				"CAST: No se puede castear de tipo: " + node.getExpr().getType() +
				" a: " + node.getCastType(), node);
		
		node.setType(node.getCastType());
		node.setModificable(false);
		
		return null;
	}
	
//	class Indexing { Expression ident;  Expression index; }
	public Object visit(Indexing node, Object param) {

		// super.visit(node, param);

		if (node.getIdent() != null)
			node.getIdent().accept(this, param);

		if (node.getIndex() != null)
			node.getIndex().accept(this, param);
		
		
		predicado(node.getIdent().getType().getClass()==ArrayType.class, 
				"INDEXING: Se esperaba: ArrayType pero se encontró: "+ node.getIdent().getType().toString(), node);
		predicado(node.getIndex().getType().getClass()==IntType.class, 
				"INDEXING: Se esperaba: IntType para el index pero se encontró: "+ node.getIndex().getType().toString(), node);
		
		if(node.getIdent().getType() instanceof ArrayType) {
			ArrayType arrt = (ArrayType) node.getIdent().getType();
			node.setType(arrt.getTypeOf());
			node.setModificable(true);
		}
		
		return null;
	}
	
//	class FieldAccess { Expression ident;  String fieldName; }
	public Object visit(FieldAccess node, Object param) {

		// super.visit(node, param);

		if (node.getIdent() != null)
			node.getIdent().accept(this, param);
		
		predicado(node.getIdent().getType().getClass()==StructType.class, 
				"FIELD ACCESS: Se esperaba un tipo Sctruct pero se encontró: " + node.getIdent().getType().toString(), node);
		if(node.getIdent().getType() instanceof StructType) {
			StructType st = (StructType) node.getIdent().getType();
			StructDef sdef = (StructDef) st.getDefinicion();
			Type tipoField = dot(node.getFieldName(), sdef);
			if(tipoField!=null) {
				node.setType(tipoField);
			} else {
				predicado(tipoField!=null, "FIELD ACCESS: El campo no ha sido definido: " + node.getFieldName(), node);
			}
		}		
		return null;
	}
	
//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		VarDefinition vdef = (VarDefinition) node.getDefinition();
		node.setType(vdef.getType());
		node.setModificable(true);
		return null;
	}
	
//	class CharConstant { char value; }
	public Object visit(CharConstant node, Object param) {
		node.setType(new CharType());
		node.setModificable(false);
		return null;
	}

	//	class IntConstant { int value; }
	public Object visit(IntConstant node, Object param) {
		node.setType(new IntType());
		node.setModificable(false);
		return null;
	}

	//	class RealConstant { float value; }
	public Object visit(RealConstant node, Object param) {
		node.setType(new RealType());
		node.setModificable(false);
		return null;
	}

	// # ----------------------------------------------------------
	// MÃ©todos auxiliares recomendados (opcionales) -------------

	// retorna true si tipoA es del mismo tipo que tipoB
	private boolean mismoTipo(Type tipoA, Type tipoB) {
		if (tipoA.getClass().equals(tipoB.getClass())) {
			return true;
		}
		return false;
	}

	// retorna true si tipo pertenece a uno de los tipos primitivos(int,real,char)
	private boolean esPrimitivo(Type tipo) {
		if (tipo instanceof IntType) {
			return true;
		}
		if (tipo instanceof RealType) {
			return true;
		}
		if (tipo instanceof CharType) {
			return true;
		}
		return false;
	}

	// retorna true si tipoInicial es casteable a tipoFinal
	private boolean esCasteable(Type tipoInicial, Type tipoFinal) {
		if (esPrimitivo(tipoInicial) && esPrimitivo(tipoFinal)) {
			if (!mismoTipo(tipoInicial, tipoFinal)) {
				return true;
			}
			return false;
		}
		return false;
	}

	// comprueba que un campo es parte de su struct y retorna su tipo
	private Type dot(String fieldName, StructDef structDef) {
		for (Definition r : structDef.getRecords()) {
			RecordDef record = (RecordDef) r;
			if (record.getName().equals(fieldName))
				return record.getTipo();
		}
		return null;
	}

	// si los parametros de la funcion que corresponde con un
	// procedimiento no coinciden
	private void checkParamsForCallProc(CallProcedure cp){
		
		FunctionDef f = (FunctionDef) cp.getDefinicion();
		FunctionType ft = (FunctionType) f.getTipo();
		
		
		if(ft.getParamDefs().size() != cp.getArgs().size()) {
			errorManager.notify("Type Checking", 
					"CALL PROCEDURE: El número de parámetros no coincide", cp.getStart());
		} else {
			for(int i = 0; i <= cp.getArgs().size()-1; i++){
				
				VarDefinition vdef = (VarDefinition) ft.getParamDefs().get(i);
				
				if(cp.getArgs().get(i).getType().getClass() != vdef.getType().getClass()){
					errorManager.notify("Type Checking", 
							"CALL PROCEDURE: El tipo del argumento es: " + cp.getArgs().get(i).getType().toString() +
							" pero se esperaba: " + vdef.getType().toString(), cp.getArgs().get(i).getStart());
				}
			}
		}
		
		
	}

	// si los parametros de la funcion que corresponde con una
	// llamada a funcion no coinciden
	private void checkParamsForCallFunction(CallFunction cp){
		FunctionDef f = (FunctionDef) cp.getDefinicion();
		FunctionType ft = (FunctionType) f.getTipo();
		
		
		if(ft.getParamDefs().size() != cp.getArguments().size()) {
			errorManager.notify("Type Checking", 
					"CALL FUNCTION: El número de parámetros no coincide", cp.getStart());
		} else {
			for(int i = 0; i <= cp.getArguments().size()-1; i++){
				
				VarDefinition vdef = (VarDefinition) ft.getParamDefs().get(i);
				
				if(cp.getArguments().get(i).getType().getClass() != vdef.getType().getClass()){
					errorManager.notify("Type Checking", 
							"CALL FUNCTION: El tipo del argumento es: " + cp.getArguments().get(i).getType().toString() +
							" pero se esperaba: " + vdef.getType().toString(), cp.getArguments().get(i).getStart());
				}
			}
		}
	}

	/**
	 * predicado. MÃ©todo auxiliar para implementar los predicados. Borrar si no se
	 * quiere usar.
	 *
	 * Ejemplos de uso (suponiendo que existe un mÃ©todo "esPrimitivo(expr)"):
	 *
	 * 1. predicado(esPrimitivo(expr.tipo), "La expresiÃ³n debe ser de un tipo
	 * primitivo", expr.getStart()); 2. predicado(esPrimitivo(expr.tipo), "La
	 * expresiÃ³n debe ser de un tipo primitivo", expr); // Se asume getStart() 3.
	 * predicado(esPrimitivo(expr.tipo), "La expresiÃ³n debe ser de un tipo
	 * primitivo");
	 *
	 * NOTA: El mÃ©todo getStart() (ejemplo 1) indica la linea/columna del fichero
	 * fuente donde estaba el nodo (y asÃ­ poder dar informaciÃ³n mÃ¡s detallada de
	 * la posiciÃ³n del error). Si se usa VGen, dicho mÃ©todo habrÃ¡ sido generado
	 * en todos los nodos del AST. No es obligatorio llamar a getStart() (ejemplo
	 * 2), ya que si se pasa el nodo, se usarÃ¡ por defecto dicha posiciÃ³n. Si no
	 * se quiere imprimir la posiciÃ³n del fichero, se puede omitir el tercer
	 * argumento (ejemplo 3).
	 *
	 * @param condition     Debe cumplirse para que no se produzca un error
	 * @param errorMessage  Se imprime si no se cumple la condiciÃ³n
	 * @param posicionError Fila y columna del fichero donde se ha producido el
	 *                      error.
	 */

	private void predicado(boolean condition, String errorMessage, AST node) {
		predicado(condition, errorMessage, node.getStart());
	}

	private void predicado(boolean condition, String errorMessage, Position position) {
		if (!condition)
			errorManager.notify("Type Checking", errorMessage, position);
	}

	@SuppressWarnings("unused")
	private void predicado(boolean condition, String errorMessage) {
		predicado(condition, errorMessage, (Position) null);
	}

	private ErrorManager errorManager;
}
