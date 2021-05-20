// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;

import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, DATA=35, CODE=36, PRINT=37, INT=38, FLOAT=39, 
		CHAR_CONSTANT=40, INT_CONSTANT=41, REAL_CONSTANT=42, IDENT=43, LINE_COMMENT=44, 
		MULTILINE_COMMENT=45, WHITESPACE=46;
	public static final int
		RULE_start = 0, RULE_opt_defs = 1, RULE_definition = 2, RULE_opt_params = 3, 
		RULE_param = 4, RULE_sentence = 5, RULE_tipo = 6, RULE_tipo_simple = 7, 
		RULE_opt_sentences = 8, RULE_opt_record_defs = 9, RULE_record_def = 10, 
		RULE_opt_exprs = 11, RULE_expr = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "opt_defs", "definition", "opt_params", "param", "sentence", 
			"tipo", "tipo_simple", "opt_sentences", "opt_record_defs", "record_def", 
			"opt_exprs", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "':'", "';'", "'('", "')'", "'{'", "'}'", "'struct'", 
			"','", "'printsp'", "'println'", "'read'", "'='", "'while'", "'if'", 
			"'else'", "'return'", "'char'", "'['", "']'", "'.'", "'<'", "'>'", "'-'", 
			"'!'", "'+'", "'*'", "'/'", "'=='", "'>='", "'<='", "'!='", "'&&'", "'||'", 
			"'DATA'", "'CODE'", "'print'", "'int'", "'float'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "DATA", 
			"CODE", "PRINT", "INT", "FLOAT", "CHAR_CONSTANT", "INT_CONSTANT", "REAL_CONSTANT", 
			"IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Program ast;
		public Opt_defsContext opt_defs;
		public Opt_defsContext opt_defs() {
			return getRuleContext(Opt_defsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			((StartContext)_localctx).opt_defs = opt_defs();
			setState(27);
			match(EOF);
			 ((StartContext)_localctx).ast =  new Program(((StartContext)_localctx).opt_defs.list); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opt_defsContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();
		public DefinitionContext definition;
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public Opt_defsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_defs; }
	}

	public final Opt_defsContext opt_defs() throws RecognitionException {
		Opt_defsContext _localctx = new Opt_defsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_opt_defs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(30);
					((Opt_defsContext)_localctx).definition = definition();
					_localctx.list.add(((Opt_defsContext)_localctx).definition.ast); 
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public Definition ast;
		public Token IDENT;
		public TipoContext tipo;
		public Opt_paramsContext opt_params;
		public Tipo_simpleContext tipo_simple;
		public Opt_defsContext opt_defs;
		public Opt_sentencesContext opt_sentences;
		public Opt_record_defsContext opt_record_defs;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Opt_paramsContext opt_params() {
			return getRuleContext(Opt_paramsContext.class,0);
		}
		public Opt_defsContext opt_defs() {
			return getRuleContext(Opt_defsContext.class,0);
		}
		public Opt_sentencesContext opt_sentences() {
			return getRuleContext(Opt_sentencesContext.class,0);
		}
		public Tipo_simpleContext tipo_simple() {
			return getRuleContext(Tipo_simpleContext.class,0);
		}
		public Opt_record_defsContext opt_record_defs() {
			return getRuleContext(Opt_record_defsContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		int _la;
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(T__0);
				setState(39);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(40);
				match(T__1);
				setState(41);
				((DefinitionContext)_localctx).tipo = tipo();
				setState(42);
				match(T__2);
				 ((DefinitionContext)_localctx).ast =  new VarDefinition(((DefinitionContext)_localctx).tipo.ast, ((DefinitionContext)_localctx).IDENT); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(46);
				match(T__3);
				setState(47);
				((DefinitionContext)_localctx).opt_params = opt_params();
				setState(48);
				match(T__4);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(49);
					match(T__1);
					setState(50);
					((DefinitionContext)_localctx).tipo_simple = tipo_simple();
					}
				}

				setState(53);
				match(T__5);
				setState(54);
				((DefinitionContext)_localctx).opt_defs = opt_defs();
				setState(55);
				((DefinitionContext)_localctx).opt_sentences = opt_sentences();
				setState(56);
				match(T__6);
				 ((DefinitionContext)_localctx).ast =  new FunctionDef(	
					((DefinitionContext)_localctx).IDENT, new FunctionType(_localctx.tipo_simple != null ? ((DefinitionContext)_localctx).tipo_simple.ast : null, ((DefinitionContext)_localctx).opt_params.list), ((DefinitionContext)_localctx).opt_defs.list, ((DefinitionContext)_localctx).opt_sentences.list); 
					_localctx.ast.setPositions(_localctx.start); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(T__7);
				setState(60);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(61);
				match(T__5);
				setState(62);
				((DefinitionContext)_localctx).opt_record_defs = opt_record_defs();
				setState(63);
				match(T__6);
				setState(64);
				match(T__2);
				 ((DefinitionContext)_localctx).ast =  new StructDef(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).opt_record_defs.list); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opt_paramsContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();
		public ParamContext e1;
		public ParamContext e2;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public Opt_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_params; }
	}

	public final Opt_paramsContext opt_params() throws RecognitionException {
		Opt_paramsContext _localctx = new Opt_paramsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_opt_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(69);
				((Opt_paramsContext)_localctx).e1 = param();
				_localctx.list.add(((Opt_paramsContext)_localctx).e1.ast); 
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(71);
					match(T__8);
					setState(72);
					((Opt_paramsContext)_localctx).e2 = param();
					_localctx.list.add(((Opt_paramsContext)_localctx).e2.ast); 
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public Definition ast;
		public Token IDENT;
		public Tipo_simpleContext tipo_simple;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public Tipo_simpleContext tipo_simple() {
			return getRuleContext(Tipo_simpleContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			((ParamContext)_localctx).IDENT = match(IDENT);
			setState(83);
			match(T__1);
			setState(84);
			((ParamContext)_localctx).tipo_simple = tipo_simple();
			((ParamContext)_localctx).ast =  new VarDefinition(((ParamContext)_localctx).tipo_simple.ast, ((ParamContext)_localctx).IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public Sentence ast;
		public ExprContext expr;
		public ExprContext l;
		public ExprContext r;
		public Opt_sentencesContext opt_sentences;
		public Opt_sentencesContext if_sentences;
		public Opt_sentencesContext else_sentences;
		public Token IDENT;
		public Opt_exprsContext opt_exprs;
		public TerminalNode PRINT() { return getToken(GrammarParser.PRINT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<Opt_sentencesContext> opt_sentences() {
			return getRuleContexts(Opt_sentencesContext.class);
		}
		public Opt_sentencesContext opt_sentences(int i) {
			return getRuleContext(Opt_sentencesContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public Opt_exprsContext opt_exprs() {
			return getRuleContext(Opt_exprsContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sentence);
		int _la;
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(PRINT);
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(88);
					((SentenceContext)_localctx).expr = expr(0);
					}
				}

				setState(91);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new Print(_localctx.expr != null ? ((SentenceContext)_localctx).expr.ast: null); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(T__9);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(94);
					((SentenceContext)_localctx).expr = expr(0);
					}
				}

				setState(97);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new Print(_localctx.expr != null ? ((SentenceContext)_localctx).expr.ast: null); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				match(T__10);
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(100);
					((SentenceContext)_localctx).expr = expr(0);
					}
				}

				setState(103);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new Print(_localctx.expr != null ? ((SentenceContext)_localctx).expr.ast: null); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				match(T__11);
				setState(106);
				((SentenceContext)_localctx).expr = expr(0);
				setState(107);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new Read(((SentenceContext)_localctx).expr.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				((SentenceContext)_localctx).l = expr(0);
				setState(111);
				match(T__12);
				setState(112);
				((SentenceContext)_localctx).r = expr(0);
				setState(113);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new Assignment(((SentenceContext)_localctx).l.ast, ((SentenceContext)_localctx).r.ast); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(116);
				match(T__13);
				setState(117);
				match(T__3);
				setState(118);
				((SentenceContext)_localctx).expr = expr(0);
				setState(119);
				match(T__4);
				setState(120);
				match(T__5);
				setState(121);
				((SentenceContext)_localctx).opt_sentences = opt_sentences();
				setState(122);
				match(T__6);
				 ((SentenceContext)_localctx).ast =  new While(((SentenceContext)_localctx).expr.ast, ((SentenceContext)_localctx).opt_sentences.list); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(125);
				match(T__14);
				setState(126);
				match(T__3);
				setState(127);
				((SentenceContext)_localctx).expr = expr(0);
				setState(128);
				match(T__4);
				setState(129);
				match(T__5);
				setState(130);
				((SentenceContext)_localctx).if_sentences = opt_sentences();
				setState(131);
				match(T__6);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(132);
					match(T__15);
					setState(133);
					match(T__5);
					setState(134);
					((SentenceContext)_localctx).else_sentences = opt_sentences();
					setState(135);
					match(T__6);
					}
				}

				 ((SentenceContext)_localctx).ast =  new IfElse(((SentenceContext)_localctx).expr.ast, ((SentenceContext)_localctx).if_sentences.list, 
				  	_localctx.else_sentences != null ? ((SentenceContext)_localctx).else_sentences.list : null
				  ); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(141);
				((SentenceContext)_localctx).IDENT = match(IDENT);
				setState(142);
				match(T__3);
				setState(143);
				((SentenceContext)_localctx).opt_exprs = opt_exprs();
				setState(144);
				match(T__4);
				setState(145);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new CallProcedure(((SentenceContext)_localctx).IDENT, ((SentenceContext)_localctx).opt_exprs.list); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(148);
				match(T__16);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(149);
					((SentenceContext)_localctx).expr = expr(0);
					}
				}

				setState(152);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new Return(_localctx.expr != null ? ((SentenceContext)_localctx).expr.ast: null); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public Type ast;
		public Token INT_CONSTANT;
		public TipoContext tipo;
		public Token IDENT;
		public TerminalNode FLOAT() { return getToken(GrammarParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tipo);
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				match(FLOAT);
				 ((TipoContext)_localctx).ast =  new RealType(); _localctx.ast.setPositions(_localctx.start); 
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(INT);
				 ((TipoContext)_localctx).ast =  new IntType(); _localctx.ast.setPositions(_localctx.start); 
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				match(T__17);
				 ((TipoContext)_localctx).ast =  new CharType(); _localctx.ast.setPositions(_localctx.start); 
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(162);
				match(T__18);
				setState(163);
				((TipoContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(164);
				match(T__19);
				setState(165);
				((TipoContext)_localctx).tipo = tipo();
				 ((TipoContext)_localctx).ast =  new ArrayType(((TipoContext)_localctx).INT_CONSTANT, ((TipoContext)_localctx).tipo.ast); _localctx.ast.setPositions(_localctx.start); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(168);
				((TipoContext)_localctx).IDENT = match(IDENT);
				 ((TipoContext)_localctx).ast =  new StructType((((TipoContext)_localctx).IDENT!=null?((TipoContext)_localctx).IDENT.getText():null)); _localctx.ast.setPositions(_localctx.start); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_simpleContext extends ParserRuleContext {
		public Type ast;
		public TerminalNode FLOAT() { return getToken(GrammarParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public Tipo_simpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_simple; }
	}

	public final Tipo_simpleContext tipo_simple() throws RecognitionException {
		Tipo_simpleContext _localctx = new Tipo_simpleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tipo_simple);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(FLOAT);
				 ((Tipo_simpleContext)_localctx).ast =  new RealType(); _localctx.ast.setPositions(_localctx.start);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(INT);
				 ((Tipo_simpleContext)_localctx).ast =  new IntType(); _localctx.ast.setPositions(_localctx.start);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(T__17);
				 ((Tipo_simpleContext)_localctx).ast =  new CharType(); _localctx.ast.setPositions(_localctx.start);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opt_sentencesContext extends ParserRuleContext {
		public List<Sentence> list = new ArrayList<Sentence>();
		public SentenceContext sentence;
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public Opt_sentencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_sentences; }
	}

	public final Opt_sentencesContext opt_sentences() throws RecognitionException {
		Opt_sentencesContext _localctx = new Opt_sentencesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_opt_sentences);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << PRINT) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				{
				setState(180);
				((Opt_sentencesContext)_localctx).sentence = sentence();
				 _localctx.list.add(((Opt_sentencesContext)_localctx).sentence.ast); 
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opt_record_defsContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();
		public Record_defContext record_def;
		public List<Record_defContext> record_def() {
			return getRuleContexts(Record_defContext.class);
		}
		public Record_defContext record_def(int i) {
			return getRuleContext(Record_defContext.class,i);
		}
		public Opt_record_defsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_record_defs; }
	}

	public final Opt_record_defsContext opt_record_defs() throws RecognitionException {
		Opt_record_defsContext _localctx = new Opt_record_defsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_opt_record_defs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(188);
				((Opt_record_defsContext)_localctx).record_def = record_def();
				_localctx.list.add(((Opt_record_defsContext)_localctx).record_def.ast); 
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Record_defContext extends ParserRuleContext {
		public Definition ast;
		public Token IDENT;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Record_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record_def; }
	}

	public final Record_defContext record_def() throws RecognitionException {
		Record_defContext _localctx = new Record_defContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_record_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			((Record_defContext)_localctx).IDENT = match(IDENT);
			setState(197);
			match(T__1);
			setState(198);
			((Record_defContext)_localctx).tipo = tipo();
			setState(199);
			match(T__2);
			 ((Record_defContext)_localctx).ast =  new RecordDef(((Record_defContext)_localctx).IDENT, ((Record_defContext)_localctx).tipo.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opt_exprsContext extends ParserRuleContext {
		public List<Expression> list = new ArrayList<Expression>();
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Opt_exprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_exprs; }
	}

	public final Opt_exprsContext opt_exprs() throws RecognitionException {
		Opt_exprsContext _localctx = new Opt_exprsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_opt_exprs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				setState(202);
				((Opt_exprsContext)_localctx).e1 = expr(0);
				_localctx.list.add(((Opt_exprsContext)_localctx).e1.ast); 
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(204);
					match(T__8);
					setState(205);
					((Opt_exprsContext)_localctx).e2 = expr(0);
					_localctx.list.add(((Opt_exprsContext)_localctx).e2.ast); 
					}
					}
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Expression ast;
		public ExprContext id;
		public ExprContext l;
		public ExprContext expr;
		public Tipo_simpleContext tipo_simple;
		public Token minus;
		public Token not;
		public Token IDENT;
		public Opt_exprsContext opt_exprs;
		public Token CHAR_CONSTANT;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token op;
		public ExprContext r;
		public ExprContext index;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Tipo_simpleContext tipo_simple() {
			return getRuleContext(Tipo_simpleContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public Opt_exprsContext opt_exprs() {
			return getRuleContext(Opt_exprsContext.class,0);
		}
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(216);
				match(T__3);
				setState(217);
				((ExprContext)_localctx).expr = expr(0);
				setState(218);
				match(T__4);
				 ((ExprContext)_localctx).ast =  ((ExprContext)_localctx).expr.ast; 
				}
				break;
			case 2:
				{
				setState(221);
				match(T__21);
				setState(222);
				((ExprContext)_localctx).tipo_simple = tipo_simple();
				setState(223);
				match(T__22);
				setState(224);
				((ExprContext)_localctx).expr = expr(12);
				 ((ExprContext)_localctx).ast =  new Cast(((ExprContext)_localctx).tipo_simple.ast, ((ExprContext)_localctx).expr.ast); 
				}
				break;
			case 3:
				{
				setState(227);
				((ExprContext)_localctx).minus = match(T__23);
				setState(228);
				((ExprContext)_localctx).expr = expr(11);
				 ((ExprContext)_localctx).ast =  new UnaryMinus(((ExprContext)_localctx).expr.ast); 
				}
				break;
			case 4:
				{
				setState(231);
				((ExprContext)_localctx).not = match(T__24);
				setState(232);
				((ExprContext)_localctx).expr = expr(10);
				 ((ExprContext)_localctx).ast =  new Not(((ExprContext)_localctx).expr.ast); 
				}
				break;
			case 5:
				{
				setState(235);
				((ExprContext)_localctx).IDENT = match(IDENT);
				setState(236);
				match(T__3);
				setState(237);
				((ExprContext)_localctx).opt_exprs = opt_exprs();
				setState(238);
				match(T__4);
				((ExprContext)_localctx).ast =  new CallFunction(((ExprContext)_localctx).IDENT, ((ExprContext)_localctx).opt_exprs.list);
				}
				break;
			case 6:
				{
				setState(241);
				((ExprContext)_localctx).IDENT = match(IDENT);
				 ((ExprContext)_localctx).ast =  new Variable(((ExprContext)_localctx).IDENT); 
				}
				break;
			case 7:
				{
				setState(243);
				((ExprContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExprContext)_localctx).ast =  new CharConstant(((ExprContext)_localctx).CHAR_CONSTANT); 
				}
				break;
			case 8:
				{
				setState(245);
				((ExprContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExprContext)_localctx).ast =  new IntConstant(((ExprContext)_localctx).INT_CONSTANT); 
				}
				break;
			case 9:
				{
				setState(247);
				((ExprContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExprContext)_localctx).ast =  new RealConstant(((ExprContext)_localctx).REAL_CONSTANT); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(281);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(252);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__25) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(253);
						((ExprContext)_localctx).r = ((ExprContext)_localctx).expr = expr(10);
						 ((ExprContext)_localctx).ast =  new Arithmetic(((ExprContext)_localctx).l.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).r.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(257);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__27) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(258);
						((ExprContext)_localctx).r = ((ExprContext)_localctx).expr = expr(9);
						 ((ExprContext)_localctx).ast =  new Arithmetic(((ExprContext)_localctx).l.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).r.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(261);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(262);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(263);
						((ExprContext)_localctx).r = ((ExprContext)_localctx).expr = expr(8);
						 ((ExprContext)_localctx).ast =  new Comparison(((ExprContext)_localctx).l.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).r.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(266);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(267);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__32 || _la==T__33) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(268);
						((ExprContext)_localctx).r = ((ExprContext)_localctx).expr = expr(7);
						 ((ExprContext)_localctx).ast =  new Logic(((ExprContext)_localctx).l.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).r.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.id = _prevctx;
						_localctx.id = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(271);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(272);
						match(T__18);
						setState(273);
						((ExprContext)_localctx).index = ((ExprContext)_localctx).expr = expr(0);
						setState(274);
						match(T__19);
						 ((ExprContext)_localctx).ast =  new Indexing(((ExprContext)_localctx).id.ast, ((ExprContext)_localctx).index.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.id = _prevctx;
						_localctx.id = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(277);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(278);
						match(T__20);
						setState(279);
						((ExprContext)_localctx).IDENT = match(IDENT);
						 ((ExprContext)_localctx).ast =  new FieldAccess(((ExprContext)_localctx).id.ast, ((ExprContext)_localctx).IDENT); 
						}
						break;
					}
					} 
				}
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u0121\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3$\n\3\f"+
		"\3\16\3\'\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\66\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4F\n"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5\5\5S\n\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\5\7\\\n\7\3\7\3\7\3\7\3\7\5\7b\n\7\3\7\3\7\3\7\3\7"+
		"\5\7h\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u008c\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0099"+
		"\n\7\3\7\3\7\5\7\u009d\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00ad\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00b5\n\t\3\n\3"+
		"\n\3\n\7\n\u00ba\n\n\f\n\16\n\u00bd\13\n\3\13\3\13\3\13\7\13\u00c2\n\13"+
		"\f\13\16\13\u00c5\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\7\r\u00d3\n\r\f\r\16\r\u00d6\13\r\5\r\u00d8\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00fc\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u011c\n\16\f\16\16\16\u011f\13"+
		"\16\3\16\2\3\32\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\6\4\2\32\32\34\34"+
		"\3\2\35\36\4\2\30\31\37\"\3\2#$\2\u013e\2\34\3\2\2\2\4%\3\2\2\2\6E\3\2"+
		"\2\2\bR\3\2\2\2\nT\3\2\2\2\f\u009c\3\2\2\2\16\u00ac\3\2\2\2\20\u00b4\3"+
		"\2\2\2\22\u00bb\3\2\2\2\24\u00c3\3\2\2\2\26\u00c6\3\2\2\2\30\u00d7\3\2"+
		"\2\2\32\u00fb\3\2\2\2\34\35\5\4\3\2\35\36\7\2\2\3\36\37\b\2\1\2\37\3\3"+
		"\2\2\2 !\5\6\4\2!\"\b\3\1\2\"$\3\2\2\2# \3\2\2\2$\'\3\2\2\2%#\3\2\2\2"+
		"%&\3\2\2\2&\5\3\2\2\2\'%\3\2\2\2()\7\3\2\2)*\7-\2\2*+\7\4\2\2+,\5\16\b"+
		"\2,-\7\5\2\2-.\b\4\1\2.F\3\2\2\2/\60\7-\2\2\60\61\7\6\2\2\61\62\5\b\5"+
		"\2\62\65\7\7\2\2\63\64\7\4\2\2\64\66\5\20\t\2\65\63\3\2\2\2\65\66\3\2"+
		"\2\2\66\67\3\2\2\2\678\7\b\2\289\5\4\3\29:\5\22\n\2:;\7\t\2\2;<\b\4\1"+
		"\2<F\3\2\2\2=>\7\n\2\2>?\7-\2\2?@\7\b\2\2@A\5\24\13\2AB\7\t\2\2BC\7\5"+
		"\2\2CD\b\4\1\2DF\3\2\2\2E(\3\2\2\2E/\3\2\2\2E=\3\2\2\2F\7\3\2\2\2GH\5"+
		"\n\6\2HO\b\5\1\2IJ\7\13\2\2JK\5\n\6\2KL\b\5\1\2LN\3\2\2\2MI\3\2\2\2NQ"+
		"\3\2\2\2OM\3\2\2\2OP\3\2\2\2PS\3\2\2\2QO\3\2\2\2RG\3\2\2\2RS\3\2\2\2S"+
		"\t\3\2\2\2TU\7-\2\2UV\7\4\2\2VW\5\20\t\2WX\b\6\1\2X\13\3\2\2\2Y[\7\'\2"+
		"\2Z\\\5\32\16\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\7\5\2\2^\u009d\b\7\1"+
		"\2_a\7\f\2\2`b\5\32\16\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\7\5\2\2d\u009d"+
		"\b\7\1\2eg\7\r\2\2fh\5\32\16\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\7\5\2\2"+
		"j\u009d\b\7\1\2kl\7\16\2\2lm\5\32\16\2mn\7\5\2\2no\b\7\1\2o\u009d\3\2"+
		"\2\2pq\5\32\16\2qr\7\17\2\2rs\5\32\16\2st\7\5\2\2tu\b\7\1\2u\u009d\3\2"+
		"\2\2vw\7\20\2\2wx\7\6\2\2xy\5\32\16\2yz\7\7\2\2z{\7\b\2\2{|\5\22\n\2|"+
		"}\7\t\2\2}~\b\7\1\2~\u009d\3\2\2\2\177\u0080\7\21\2\2\u0080\u0081\7\6"+
		"\2\2\u0081\u0082\5\32\16\2\u0082\u0083\7\7\2\2\u0083\u0084\7\b\2\2\u0084"+
		"\u0085\5\22\n\2\u0085\u008b\7\t\2\2\u0086\u0087\7\22\2\2\u0087\u0088\7"+
		"\b\2\2\u0088\u0089\5\22\n\2\u0089\u008a\7\t\2\2\u008a\u008c\3\2\2\2\u008b"+
		"\u0086\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\7"+
		"\1\2\u008e\u009d\3\2\2\2\u008f\u0090\7-\2\2\u0090\u0091\7\6\2\2\u0091"+
		"\u0092\5\30\r\2\u0092\u0093\7\7\2\2\u0093\u0094\7\5\2\2\u0094\u0095\b"+
		"\7\1\2\u0095\u009d\3\2\2\2\u0096\u0098\7\23\2\2\u0097\u0099\5\32\16\2"+
		"\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b"+
		"\7\5\2\2\u009b\u009d\b\7\1\2\u009cY\3\2\2\2\u009c_\3\2\2\2\u009ce\3\2"+
		"\2\2\u009ck\3\2\2\2\u009cp\3\2\2\2\u009cv\3\2\2\2\u009c\177\3\2\2\2\u009c"+
		"\u008f\3\2\2\2\u009c\u0096\3\2\2\2\u009d\r\3\2\2\2\u009e\u009f\7)\2\2"+
		"\u009f\u00ad\b\b\1\2\u00a0\u00a1\7(\2\2\u00a1\u00ad\b\b\1\2\u00a2\u00a3"+
		"\7\24\2\2\u00a3\u00ad\b\b\1\2\u00a4\u00a5\7\25\2\2\u00a5\u00a6\7+\2\2"+
		"\u00a6\u00a7\7\26\2\2\u00a7\u00a8\5\16\b\2\u00a8\u00a9\b\b\1\2\u00a9\u00ad"+
		"\3\2\2\2\u00aa\u00ab\7-\2\2\u00ab\u00ad\b\b\1\2\u00ac\u009e\3\2\2\2\u00ac"+
		"\u00a0\3\2\2\2\u00ac\u00a2\3\2\2\2\u00ac\u00a4\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ad\17\3\2\2\2\u00ae\u00af\7)\2\2\u00af\u00b5\b\t\1\2\u00b0\u00b1"+
		"\7(\2\2\u00b1\u00b5\b\t\1\2\u00b2\u00b3\7\24\2\2\u00b3\u00b5\b\t\1\2\u00b4"+
		"\u00ae\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\21\3\2\2"+
		"\2\u00b6\u00b7\5\f\7\2\u00b7\u00b8\b\n\1\2\u00b8\u00ba\3\2\2\2\u00b9\u00b6"+
		"\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\23\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\5\26\f\2\u00bf\u00c0\b\13"+
		"\1\2\u00c0\u00c2\3\2\2\2\u00c1\u00be\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\25\3\2\2\2\u00c5\u00c3\3\2\2"+
		"\2\u00c6\u00c7\7-\2\2\u00c7\u00c8\7\4\2\2\u00c8\u00c9\5\16\b\2\u00c9\u00ca"+
		"\7\5\2\2\u00ca\u00cb\b\f\1\2\u00cb\27\3\2\2\2\u00cc\u00cd\5\32\16\2\u00cd"+
		"\u00d4\b\r\1\2\u00ce\u00cf\7\13\2\2\u00cf\u00d0\5\32\16\2\u00d0\u00d1"+
		"\b\r\1\2\u00d1\u00d3\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2"+
		"\2\2\u00d7\u00cc\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\31\3\2\2\2\u00d9\u00da"+
		"\b\16\1\2\u00da\u00db\7\6\2\2\u00db\u00dc\5\32\16\2\u00dc\u00dd\7\7\2"+
		"\2\u00dd\u00de\b\16\1\2\u00de\u00fc\3\2\2\2\u00df\u00e0\7\30\2\2\u00e0"+
		"\u00e1\5\20\t\2\u00e1\u00e2\7\31\2\2\u00e2\u00e3\5\32\16\16\u00e3\u00e4"+
		"\b\16\1\2\u00e4\u00fc\3\2\2\2\u00e5\u00e6\7\32\2\2\u00e6\u00e7\5\32\16"+
		"\r\u00e7\u00e8\b\16\1\2\u00e8\u00fc\3\2\2\2\u00e9\u00ea\7\33\2\2\u00ea"+
		"\u00eb\5\32\16\f\u00eb\u00ec\b\16\1\2\u00ec\u00fc\3\2\2\2\u00ed\u00ee"+
		"\7-\2\2\u00ee\u00ef\7\6\2\2\u00ef\u00f0\5\30\r\2\u00f0\u00f1\7\7\2\2\u00f1"+
		"\u00f2\b\16\1\2\u00f2\u00fc\3\2\2\2\u00f3\u00f4\7-\2\2\u00f4\u00fc\b\16"+
		"\1\2\u00f5\u00f6\7*\2\2\u00f6\u00fc\b\16\1\2\u00f7\u00f8\7+\2\2\u00f8"+
		"\u00fc\b\16\1\2\u00f9\u00fa\7,\2\2\u00fa\u00fc\b\16\1\2\u00fb\u00d9\3"+
		"\2\2\2\u00fb\u00df\3\2\2\2\u00fb\u00e5\3\2\2\2\u00fb\u00e9\3\2\2\2\u00fb"+
		"\u00ed\3\2\2\2\u00fb\u00f3\3\2\2\2\u00fb\u00f5\3\2\2\2\u00fb\u00f7\3\2"+
		"\2\2\u00fb\u00f9\3\2\2\2\u00fc\u011d\3\2\2\2\u00fd\u00fe\f\13\2\2\u00fe"+
		"\u00ff\t\2\2\2\u00ff\u0100\5\32\16\f\u0100\u0101\b\16\1\2\u0101\u011c"+
		"\3\2\2\2\u0102\u0103\f\n\2\2\u0103\u0104\t\3\2\2\u0104\u0105\5\32\16\13"+
		"\u0105\u0106\b\16\1\2\u0106\u011c\3\2\2\2\u0107\u0108\f\t\2\2\u0108\u0109"+
		"\t\4\2\2\u0109\u010a\5\32\16\n\u010a\u010b\b\16\1\2\u010b\u011c\3\2\2"+
		"\2\u010c\u010d\f\b\2\2\u010d\u010e\t\5\2\2\u010e\u010f\5\32\16\t\u010f"+
		"\u0110\b\16\1\2\u0110\u011c\3\2\2\2\u0111\u0112\f\20\2\2\u0112\u0113\7"+
		"\25\2\2\u0113\u0114\5\32\16\2\u0114\u0115\7\26\2\2\u0115\u0116\b\16\1"+
		"\2\u0116\u011c\3\2\2\2\u0117\u0118\f\17\2\2\u0118\u0119\7\27\2\2\u0119"+
		"\u011a\7-\2\2\u011a\u011c\b\16\1\2\u011b\u00fd\3\2\2\2\u011b\u0102\3\2"+
		"\2\2\u011b\u0107\3\2\2\2\u011b\u010c\3\2\2\2\u011b\u0111\3\2\2\2\u011b"+
		"\u0117\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011e\33\3\2\2\2\u011f\u011d\3\2\2\2\26%\65EOR[ag\u008b\u0098\u009c"+
		"\u00ac\u00b4\u00bb\u00c3\u00d4\u00d7\u00fb\u011b\u011d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}