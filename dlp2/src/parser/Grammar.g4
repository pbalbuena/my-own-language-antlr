grammar Grammar
	;
import Lexicon
	;
@parser::header {
import ast.*;
}

start returns[Program ast]
: opt_defs EOF { $ast = new Program($opt_defs.list); }
;

opt_defs returns[List<Definition> list = new ArrayList<Definition>()]
: (definition {$list.add($definition.ast); })*
;


definition returns [Definition ast]
: 'var' IDENT ':' tipo ';' { $ast = new VarDefinition($tipo.ast, $IDENT); }
| IDENT '(' opt_params ')' (':' tipo_simple)? '{' opt_defs opt_sentences '}' { $ast = new FunctionDef(	
	$IDENT, new FunctionType($ctx.tipo_simple != null ? $tipo_simple.ast : null, $opt_params.list), $opt_defs.list, $opt_sentences.list); 
	$ast.setPositions($ctx.start); }
| 'struct' IDENT '{' opt_record_defs '}' ';'
{ $ast = new StructDef($IDENT, $opt_record_defs.list); }
;

opt_params returns[List<Definition> list = new ArrayList<Definition>()]
: (e1=param {$list.add($e1.ast); } (',' e2=param {$list.add($e2.ast); })*)?
;

param returns[Definition ast]
: IDENT ':' tipo_simple {$ast = new VarDefinition($tipo_simple.ast, $IDENT);}
;

sentence returns[Sentence ast]
: 'print' expr? ';' { $ast = new Print($ctx.expr != null ? $expr.ast: null); }
| 'printsp' expr? ';' { $ast = new Print($ctx.expr != null ? $expr.ast: null); }
| 'println' expr? ';' { $ast = new Print($ctx.expr != null ? $expr.ast: null); }
| 'read' expr ';' { $ast = new Read($expr.ast); }
| l=expr '=' r=expr ';' { $ast = new Assignment($l.ast, $r.ast); }
| 'while' '(' expr ')' '{' opt_sentences '}' { $ast = new While($expr.ast, $opt_sentences.list); }
| 'if' '(' expr ')' '{' if_sentences=opt_sentences '}' ('else' '{' else_sentences=opt_sentences '}')?
  { $ast = new IfElse($expr.ast, $if_sentences.list, 
  	$ctx.else_sentences != null ? $else_sentences.list : null
  ); }
| IDENT '(' opt_exprs ')' ';' { $ast = new CallProcedure($IDENT, $opt_exprs.list); }
| 'return' expr? ';' { $ast = new Return($ctx.expr != null ? $expr.ast: null); }
;

tipo returns[Type ast]
: 'float' { $ast = new RealType(); $ast.setPositions($ctx.start); }
| 'int' { $ast = new IntType(); $ast.setPositions($ctx.start); }
| 'char' { $ast = new CharType(); $ast.setPositions($ctx.start); }
| '[' INT_CONSTANT ']' tipo { $ast = new ArrayType($INT_CONSTANT, $tipo.ast); $ast.setPositions($ctx.start); }
| IDENT { $ast = new StructType($IDENT.text); $ast.setPositions($ctx.start); }
;

tipo_simple returns[Type ast]
: 'float' { $ast = new RealType(); $ast.setPositions($ctx.start);}
| 'int' { $ast = new IntType(); $ast.setPositions($ctx.start);}
| 'char' { $ast = new CharType(); $ast.setPositions($ctx.start);}
;

opt_sentences returns[List<Sentence> list = new ArrayList<Sentence>()]
: (sentence { $list.add($sentence.ast); })*
;

opt_record_defs returns[List<Definition> list = new ArrayList<Definition>()]
: (record_def {$list.add($record_def.ast); })*
;

record_def returns [Definition ast]
: IDENT ':' tipo ';' { $ast = new RecordDef($IDENT, $tipo.ast); }
;

opt_exprs returns[List<Expression> list = new ArrayList<Expression>()]
: (e1=expr {$list.add($e1.ast); } (',' e2=expr {$list.add($e2.ast); })*)?
;

expr returns[Expression ast]
: '(' expr ')' { $ast = $expr.ast; }
| id=expr '[' index=expr ']' { $ast = new Indexing($id.ast, $index.ast); }
| id=expr '.' IDENT { $ast = new FieldAccess($id.ast, $IDENT); }
| '<' tipo_simple '>' expr { $ast = new Cast($tipo_simple.ast, $expr.ast); }
| minus='-' expr { $ast = new UnaryMinus($expr.ast); }
| not='!' expr { $ast = new Not($expr.ast); }
| l=expr op=('+' | '-') r=expr { $ast = new Arithmetic($l.ast, $op, $r.ast); }
| l=expr op=('*' | '/') r=expr { $ast = new Arithmetic($l.ast, $op, $r.ast); }
| l=expr op=('>'|'<'|'=='|'>='|'<='|'!=') r=expr { $ast = new Comparison($l.ast, $op, $r.ast); }
| l=expr op=('&&'|'||') r=expr { $ast = new Logic($l.ast, $op, $r.ast); }
| IDENT '(' opt_exprs ')' {$ast = new CallFunction($IDENT, $opt_exprs.list);}
| IDENT { $ast = new Variable($IDENT); }
| CHAR_CONSTANT { $ast = new CharConstant($CHAR_CONSTANT); }
| INT_CONSTANT { $ast = new IntConstant($INT_CONSTANT); }
| REAL_CONSTANT { $ast = new RealConstant($REAL_CONSTANT); }
;

