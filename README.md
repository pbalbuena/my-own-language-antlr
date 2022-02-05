# Diseño de lenguaje de programación con ANTLR
Este es un proyecto diseño de un lenguaje con ANTLR 

El lenguaje permite definición de variables y funciones y sigue la siguiente gramática abstracta.

```
CATEGORIES
expression, sentence, type, definition

NODES
program -> definitions:definition*;

varDef:definition -> type name:string;
funcDef:definition -> ident:string tipoRetorno:type parametros:varDef* localDefs:varDef* sentence*;
structDef:definition -> name:string records:recordDef*;
recordDef:definition -> name:string type;


intType:type -> ;
realType:type -> ;
charType:type -> ;
arrayType:type -> length:int typeOf:type;
structType:type -> name:string;


print:sentence -> expression tipoPrint:int;
assignment:sentence -> left:expression right:expression;
callProcedure:sentence -> ident:string arguments:expression*;
ifElse:sentence -> condition:expression ifSentences:sentence* elseSentences:sentence*;
read:sentence -> expression;
return:sentence -> expression;
while:sentence -> condition:expression whileSentences:sentence*;


arithmetic:expression -> left:expression operator:string right:expression;
callFunction:expression -> ident:string arguments:expression*;
cast:expression -> castType:type expression;
comparison:expression -> left:expression operator:string right:expression;
fieldAccess:expression -> ident:expression fieldName:string;
indexing:expression -> ident:expression index:expression;
logic:expression -> left:expression operator:string right:expression;
not:expression -> expression;
unaryMinus:expression -> expression;
variable:expression -> name:string;
charConstant:expression -> value:string;
intConstant:expression -> value:string;
realConstant:expression -> value:string;
```

Para preguntas sobre el proyecto, correo a pbalbuena13@gmail.com
