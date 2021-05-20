/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import ast.AST;
import ast.Arithmetic;
import ast.Assignment;
import ast.CallFunction;
import ast.CallProcedure;
import ast.CharConstant;
import ast.Comparison;
import ast.Definition;
import ast.Expression;
import ast.FieldAccess;
import ast.FunctionDef;
import ast.FunctionType;
import ast.IfElse;
import ast.Indexing;
import ast.IntConstant;
import ast.Logic;
import ast.Position;
import ast.Print;
import ast.Program;
import ast.Read;
import ast.RealConstant;
import ast.RecordDef;
import ast.Return;
import ast.Sentence;
import ast.StructDef;
import ast.Type;
import ast.UnaryMinus;
import ast.VarDefinition;
import ast.Variable;
import ast.While;
import visitor.DefaultVisitor;

enum CodeFunction {
	ADDRESS, VALUE
}

public class CodeSelection extends DefaultVisitor {

	private Map<String, String> instruccion = new HashMap<String, String>();

	private int labelCounter = 0;
	
	public CodeSelection(Writer writer, String sourceFile) {
		this.writer = new PrintWriter(writer);
		this.sourceFile = sourceFile;

		//arithmetic
		instruccion.put("+", "add");
		instruccion.put("-", "sub");
		instruccion.put("*", "mul");
		instruccion.put("/", "div");
		//logic
		instruccion.put("&&", "and");
		instruccion.put("||", "or");
		instruccion.put("!", "not");
		//comparison
		instruccion.put(">", "gt");
		instruccion.put("<", "lt");
		instruccion.put(">=", "ge");
		instruccion.put("<=", "le");
		instruccion.put("==", "eq");
		instruccion.put("!=", "ne");
	}

	// # ----------------------------------------------------------
	/*
	 * Poner aquí los visit.
	 *
	 * Si se ha usado VGen, solo hay que copiarlos de la clase
	 * 'visitor/_PlantillaParaVisitors.txt'.
	 */

//	class Program { List<Definition> definitions; }
	public Object visit(Program node, Object param) {

		// super.visit(node, param);

		out("#source \"" + sourceFile + "\"");

		out("call main");
		out("halt");
		
		if (node.getDefinitions() != null)
			for (Definition child : node.getDefinitions())
				child.accept(this, param);

		

		return null;
	}

//	class FunctionDef { String ident;  Type tipo;  List<Definition> localDefs;  List<Sentence> stats; }
	public Object visit(FunctionDef node, Object param) {

		// super.visit(node, param);

		out("#FUNC " + node.getIdent());
		line(node);

		out(node.getIdent()+":");
		
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);

		if (node.getLocalDefs() != null)
			for (Definition child : node.getLocalDefs())
				child.accept(this, param);

		// despues de visitar las variables locales hacemos un enter del espacio
		// requerido
		if(node.getLocalBytes() > 0 ) {
			out("enter " + node.getLocalBytes());
		}
		
		
		if (node.getStats() != null)
			for (Sentence child : node.getStats())
				child.accept(this, param);

		//si no tiene tipo de retorno la funcion
		FunctionType ftype = (FunctionType) node.getTipo();
		if(ftype.getRetType() == null) {
			int locales = node.getLocalBytes();
			int parametros = ftype.getSize();
			out("ret 0,"+locales+","+parametros);
		}
		
		return null;
	}

//	class VarDefinition { Type type;  String name; }
	public Object visit(VarDefinition node, Object param) {

		// super.visit(node, param);

		// comment(node);
		line(node);

		if (node.getType() != null)
			node.getType().accept(this, param);
		
		switch(node.getAmbito()) {
		case 0:
			out("#GLOBAL " + node.getName() + ":" + node.getType().getMAPLName());
			break;
		case 1:
			out("#LOCAL " + node.getName() + ":" + node.getType().getMAPLName());
			break;
		case 2:
			out("#PARAM " + node.getName() + ":" + node.getType().getMAPLName());
			break;
		}
		return null;
	}
	
//	class StructDef { String name;  Type tipo;  List<Definition> records; }
	public Object visit(StructDef node, Object param) {

		// super.visit(node, param);

		line(node);
		out("#TYPE " + node.getName() + ": { \n" 
				
				+"}");
		
		if (node.getRecords() != null)
			for (Definition child : node.getRecords())
				child.accept(this, param);

		return null;
	}

	//	class RecordDef { String name;  Type tipo; }
	public Object visit(RecordDef node, Object param) {

		// super.visit(node, param);

		if (node.getTipo() != null)
			node.getTipo().accept(this, param);

		return null;
	}

//	class Print { Expression expression; }
	public Object visit(Print node, Object param) {

		// super.visit(node, param);

		// comment(node);
		line(node);

		if (node.getExpression() != null)
			node.getExpression().accept(this, CodeFunction.VALUE);

		out("out", node.getExpression().getType());

		return null;
	}
	
//	class Read { Expression expression; }
	public Object visit(Read node, Object param) {

		// super.visit(node, param);
		line(node);

		if (node.getExpression() != null)
			node.getExpression().accept(this, CodeFunction.ADDRESS);

		out("in"+node.getExpression().getType().getSuffix());
		out("store"+node.getExpression().getType().getSuffix());
		
		return null;
	}
	
//	class Return { Expression expr; }
	public Object visit(Return node, Object param) {

		// super.visit(node, param);

		line(node);
		
		out("#RET " + node.getExpr().getType().getMAPLName());
		
		if (node.getExpr() != null) {
			node.getExpr().accept(this, CodeFunction.VALUE);
			
			int funcion;
			int locales;
			int params;
			funcion = node.getTipoRetorno().getSize();
			locales = node.getFunctionDefinition().getLocalBytes();
			FunctionType ftype = (FunctionType) node.getFunctionDefinition().getTipo();
			params = ftype.getSize();
			out("ret " + funcion + ","+locales+","+params);		
		}
		return null;
	}	
	
//	class IfElse { Expression condition;  List<Sentence> ifSentences;  List<Sentence> elseSentences; }
	public Object visit(IfElse node, Object param) {

		// super.visit(node, param);
		line(node);
		
		//para que no se mezcle con los otros labels
		int localLabel = labelCounter++;
		
		if (node.getCondition() != null)
			node.getCondition().accept(this, CodeFunction.VALUE);
		
		//no es necesario poner etiqueta al if ya que nunca volvemos a �l
		//out("if"+ labelCounter + ":"); 
		
		out("jz else"+localLabel);

		if (node.getIfSentences() != null)
			for (Sentence child : node.getIfSentences())
				child.accept(this, CodeFunction.VALUE);
		
		out("jmp fin_else"+localLabel);
		out("else"+ localLabel + ":");

		if (node.getElseSentences() != null)
			for (Sentence child : node.getElseSentences())
				child.accept(this, CodeFunction.VALUE);

        out("fin_else"+ localLabel + ":");
        
		return null;
	}
	
//	class While { Expression condition;  List<Sentence> whileSentences; }
	public Object visit(While node, Object param) {

		// super.visit(node, param);
		line(node);

		//para que no se mezcle con los otros labels
		int localLabel = labelCounter++;
		
		out("while"+ localLabel + ":"); 
		
		if (node.getCondition() != null)
			node.getCondition().accept(this, CodeFunction.VALUE);
		
		out("jz fin_while"+localLabel);
		
		if (node.getWhileSentences() != null)
			for (Sentence child : node.getWhileSentences())
				child.accept(this, param);

		out("jmp while"+localLabel);
		out("fin_while"+localLabel+":");
		
		return null;
	}
	
//	class CallProcedure { String ident;  List<Expression> args; }
	public Object visit(CallProcedure node, Object param) {

		// super.visit(node, param);
		line(node);

		if (node.getArgs() != null)
			for (Expression child : node.getArgs())
				child.accept(this, CodeFunction.VALUE);
		
		out("call " + node.getIdent());
		FunctionDef fdef = (FunctionDef) node.getDefinicion();
		FunctionType ftype = (FunctionType) fdef.getTipo();
		if(ftype.getRetType()!=null) {
			out("pop"+ftype.getRetType().getSuffix());
		}

		return null;
	}

//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {

		// super.visit(node, param);

		// comment(node);
		line(node);

		// en la pila metemos primero address y luego value
		if (node.getLeft() != null)
			node.getLeft().accept(this, CodeFunction.ADDRESS);

		if (node.getRight() != null)
			node.getRight().accept(this, CodeFunction.VALUE);

		out("store", node.getLeft().getType());

		return null;
	}

//	class Arithmetic { Expression left;  String op;  Expression right; }
	public Object visit(Arithmetic node, Object param) {

		// super.visit(node, param);

		assert (param == CodeFunction.VALUE);

		if (node.getLeft() != null)
			node.getLeft().accept(this, CodeFunction.VALUE);

		if (node.getRight() != null)
			node.getRight().accept(this, CodeFunction.VALUE);

		out(instruccion.get(node.getOp()), node.getType());

		return null;
	}
	
//	class Logic { Expression left;  String op;  Expression right; }
	public Object visit(Logic node, Object param) {

		// super.visit(node, param);
		
		assert (param == CodeFunction.VALUE);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);
		
		out(instruccion.get(node.getOp()));

		return null;
	}

	//	class Comparison { Expression left;  String op;  Expression right; }
	public Object visit(Comparison node, Object param) {

		// super.visit(node, param);
		
		assert (param == CodeFunction.VALUE);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);
		
		out(instruccion.get(node.getOp()), node.getLeft().getType());

		return null;
	}

	// class Variable { String name; }
	public Object visit(Variable node, Object param) {
		if (((CodeFunction) param) == CodeFunction.VALUE) {
			visit(node, CodeFunction.ADDRESS);
			out("load", node.getType());
		} else { // Funcion.DIRECCION
			assert (param == CodeFunction.ADDRESS);
			// check si es local o global
			VarDefinition vdef = (VarDefinition) node.getDefinition();
			if (vdef.getAmbito() > 0) { // si es local/parametro
				out("pusha BP");
				out("push " + vdef.getAddress());
				out("add");
			} else { // si es global
				out("pusha " + vdef.getAddress());
			}
		}
		return null;
	}
	
//	class CallFunction { String ident;  List<Expression> arguments; }
	public Object visit(CallFunction node, Object param) {

		// super.visit(node, param);

		if (node.getArguments() != null)
			for (Expression child : node.getArguments())
				child.accept(this, CodeFunction.VALUE);

		out("call " + node.getIdent() );
		
		return null;
	}
	
//	class UnaryMinus { Expression expr; }
	public Object visit(UnaryMinus node, Object param) {

		// super.visit(node, param);

		if (node.getExpr() != null)
			node.getExpr().accept(this, CodeFunction.VALUE);

		out("push"+ node.getType().getSuffix() + " -1");
		out("mul" + node.getType().getSuffix());
		
		return null;
	}
	
	
//	class FieldAccess { Expression ident;  String fieldName; }
	public Object visit(FieldAccess node, Object param) {

		// super.visit(node, param);

		if (node.getIdent() != null)
			node.getIdent().accept(this, CodeFunction.ADDRESS);

		out("load" + node.getType());
		
		return null;
	}
	
//	class Indexing { Expression ident;  Expression index; }
	public Object visit(Indexing node, Object param) {

		// super.visit(node, param);

		if (node.getIdent() != null)
			node.getIdent().accept(this, CodeFunction.ADDRESS);

		if (node.getIndex() != null)
			node.getIndex().accept(this, CodeFunction.VALUE);

		//multiplico el valor del index por el tipo del array para tener su numero de bytes
		out("pushi " + node.getType().getSize());
        out("muli");
        //lo sumo a la address para obtener el valor final
        out("addi");
        
        if(param == CodeFunction.VALUE) {
        	out("load", node.getType());
        }

		return null;
	}

	// class CharConstant { String valor; }
	public Object visit(CharConstant node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("pushb " + node.getValue());
		return null;
	}

	// class IntConstant { String valor; }
	public Object visit(IntConstant node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("push " + node.getValue());
		return null;
	}

	// class RealConstant { String valor; }
	public Object visit(RealConstant node, Object param) {
		assert (param == CodeFunction.VALUE);
		out("pushf " + node.getValue());
		return null;
	}

	// Ejemplo:
	//
	// public Object visit(Program node, Object param) {
	// out("#source \"" + sourceFile + "\"");
	// out("call main");
	// out("halt");
	//
	// super.visit(node, param); // Recorrer los hijos
	// return null;
	// }

	// # ----------------------------------------------------------
	// Métodos auxiliares recomendados (opcionales) -------------

	// Imprime una línea en el fichero de salida
	private void out(String instruction) {
		writer.println(instruction);
	}

	private void out(String instruccion, Type tipo) {
		out(instruccion + tipo.getSuffix());
	}

	private void comment(AST node) {
		out("'" + node.getClass().getSimpleName());
	}

	private void line(AST node) {
		line(node.getEnd());
	}

	private void line(Position pos) {
		if (pos != null)
			out("\n#line " + pos.getLine());
		else
			System.out.println("#line no generado. Se ha pasado una Position null. Falta información en el AST");
	}

	private PrintWriter writer;
	private String sourceFile;
}
