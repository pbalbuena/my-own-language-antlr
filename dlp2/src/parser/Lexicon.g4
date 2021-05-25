lexer grammar Lexicon
	;

PRINT: 'print';

INT:	'int';
FLOAT:	'float';

CHAR_CONSTANT: '\'' ('\\'INT_CONSTANT | '\\n' | '\\t' | '\\r' | .) '\'';
INT_CONSTANT:	[0-9]+;
REAL_CONSTANT:	[0-9]+ '.' [0-9]+;
IDENT:			[a-zA-Z][a-zA-Z0-9_]*;


LINE_COMMENT:		'//' .*? ('\n'|EOF)	-> skip;
MULTILINE_COMMENT:	'/*' .*? '*/'	-> skip;

WHITESPACE: [ \t\r\n]+ -> skip;
