// Generated from Tune.g4 by ANTLR 4.1

package pipes.editing.io;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TuneParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, TEXT=3, TimeSignature=4, NOTENAME=5, NUMBER=6, TIE=7, 
		START_REPEAT=8, END_REPEAT=9, EMBELLISHMENT=10, WS=11, LINE=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "'|'", "TEXT", "TimeSignature", "NOTENAME", "NUMBER", 
		"'-'", "'|:'", "':|'", "EMBELLISHMENT", "WS", "LINE"
	};
	public static final int
		RULE_tune = 0, RULE_name = 1, RULE_author = 2, RULE_type = 3, RULE_line = 4, 
		RULE_measure = 5, RULE_melodyElement = 6, RULE_note = 7;
	public static final String[] ruleNames = {
		"tune", "name", "author", "type", "line", "measure", "melodyElement", 
		"note"
	};

	@Override
	public String getGrammarFileName() { return "Tune.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public TuneParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TuneContext extends ParserRuleContext {
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public TerminalNode LINE(int i) {
			return getToken(TuneParser.LINE, i);
		}
		public AuthorContext author() {
			return getRuleContext(AuthorContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public List<TerminalNode> LINE() { return getTokens(TuneParser.LINE); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TuneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tune; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).enterTune(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).exitTune(this);
		}
	}

	public final TuneContext tune() throws RecognitionException {
		TuneContext _localctx = new TuneContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_tune);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(16); name();
			setState(17); match(LINE);
			setState(18); author();
			setState(19); match(LINE);
			setState(20); type();
			setState(21); match(LINE);
			setState(27);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(22); line();
					setState(23); match(LINE);
					}
					} 
				}
				setState(29);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(30); line();
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(TuneParser.TEXT, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); match(TEXT);
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

	public static class AuthorContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(TuneParser.TEXT, 0); }
		public AuthorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_author; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).enterAuthor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).exitAuthor(this);
		}
	}

	public final AuthorContext author() throws RecognitionException {
		AuthorContext _localctx = new AuthorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_author);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); match(TEXT);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(TuneParser.TEXT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(TEXT);
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

	public static class LineContext extends ParserRuleContext {
		public List<MeasureContext> measure() {
			return getRuleContexts(MeasureContext.class);
		}
		public MeasureContext measure(int i) {
			return getRuleContext(MeasureContext.class,i);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38); measure();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << TimeSignature) | (1L << NOTENAME) | (1L << TIE) | (1L << START_REPEAT) | (1L << END_REPEAT) | (1L << EMBELLISHMENT) | (1L << WS))) != 0) );
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

	public static class MeasureContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(TuneParser.WS); }
		public MelodyElementContext melodyElement(int i) {
			return getRuleContext(MelodyElementContext.class,i);
		}
		public List<MelodyElementContext> melodyElement() {
			return getRuleContexts(MelodyElementContext.class);
		}
		public TerminalNode TimeSignature() { return getToken(TuneParser.TimeSignature, 0); }
		public TerminalNode WS(int i) {
			return getToken(TuneParser.WS, i);
		}
		public TerminalNode END_REPEAT() { return getToken(TuneParser.END_REPEAT, 0); }
		public TerminalNode START_REPEAT() { return getToken(TuneParser.START_REPEAT, 0); }
		public MeasureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_measure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).enterMeasure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).exitMeasure(this);
		}
	}

	public final MeasureContext measure() throws RecognitionException {
		MeasureContext _localctx = new MeasureContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_measure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if (_la==START_REPEAT) {
				{
				setState(43); match(START_REPEAT);
				setState(44); match(WS);
				}
			}

			setState(48);
			_la = _input.LA(1);
			if (_la==TimeSignature) {
				{
				setState(47); match(TimeSignature);
				}
			}

			setState(51);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(50); match(WS);
				}
			}

			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOTENAME) | (1L << TIE) | (1L << EMBELLISHMENT))) != 0)) {
				{
				{
				setState(53); melodyElement();
				setState(54); match(WS);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			_la = _input.LA(1);
			if (_la==END_REPEAT) {
				{
				setState(61); match(END_REPEAT);
				setState(62); match(WS);
				}
			}

			setState(65); match(2);
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

	public static class MelodyElementContext extends ParserRuleContext {
		public NoteContext note() {
			return getRuleContext(NoteContext.class,0);
		}
		public TerminalNode TIE() { return getToken(TuneParser.TIE, 0); }
		public TerminalNode EMBELLISHMENT() { return getToken(TuneParser.EMBELLISHMENT, 0); }
		public MelodyElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_melodyElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).enterMelodyElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).exitMelodyElement(this);
		}
	}

	public final MelodyElementContext melodyElement() throws RecognitionException {
		MelodyElementContext _localctx = new MelodyElementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_melodyElement);
		try {
			setState(70);
			switch (_input.LA(1)) {
			case EMBELLISHMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(67); match(EMBELLISHMENT);
				}
				break;
			case NOTENAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(68); note();
				}
				break;
			case TIE:
				enterOuterAlt(_localctx, 3);
				{
				setState(69); match(TIE);
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

	public static class NoteContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(TuneParser.NUMBER, 0); }
		public TerminalNode NOTENAME() { return getToken(TuneParser.NOTENAME, 0); }
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TuneListener ) ((TuneListener)listener).exitNote(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); match(NOTENAME);
			setState(73); match(TIE);
			setState(74); match(NUMBER);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(75); match(1);
				}
				}
				setState(80);
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\16T\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\6\6*\n\6\r\6\16\6+\3\7\3\7\5\7\60\n\7\3\7\5\7\63\n\7\3\7\5"+
		"\7\66\n\7\3\7\3\7\3\7\7\7;\n\7\f\7\16\7>\13\7\3\7\3\7\5\7B\n\7\3\7\3\7"+
		"\3\b\3\b\3\b\5\bI\n\b\3\t\3\t\3\t\3\t\7\tO\n\t\f\t\16\tR\13\t\3\t\2\n"+
		"\2\4\6\b\n\f\16\20\2\2U\2\22\3\2\2\2\4\"\3\2\2\2\6$\3\2\2\2\b&\3\2\2\2"+
		"\n)\3\2\2\2\f/\3\2\2\2\16H\3\2\2\2\20J\3\2\2\2\22\23\5\4\3\2\23\24\7\16"+
		"\2\2\24\25\5\6\4\2\25\26\7\16\2\2\26\27\5\b\5\2\27\35\7\16\2\2\30\31\5"+
		"\n\6\2\31\32\7\16\2\2\32\34\3\2\2\2\33\30\3\2\2\2\34\37\3\2\2\2\35\33"+
		"\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\5\n\6\2!\3\3\2\2\2"+
		"\"#\7\5\2\2#\5\3\2\2\2$%\7\5\2\2%\7\3\2\2\2&\'\7\5\2\2\'\t\3\2\2\2(*\5"+
		"\f\7\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\13\3\2\2\2-.\7\n\2\2."+
		"\60\7\r\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61\63\7\6\2\2\62\61\3"+
		"\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\66\7\r\2\2\65\64\3\2\2\2\65\66\3"+
		"\2\2\2\66<\3\2\2\2\678\5\16\b\289\7\r\2\29;\3\2\2\2:\67\3\2\2\2;>\3\2"+
		"\2\2<:\3\2\2\2<=\3\2\2\2=A\3\2\2\2><\3\2\2\2?@\7\13\2\2@B\7\r\2\2A?\3"+
		"\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7\4\2\2D\r\3\2\2\2EI\7\f\2\2FI\5\20\t\2G"+
		"I\7\t\2\2HE\3\2\2\2HF\3\2\2\2HG\3\2\2\2I\17\3\2\2\2JK\7\7\2\2KL\7\t\2"+
		"\2LP\7\b\2\2MO\7\3\2\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\21\3\2"+
		"\2\2RP\3\2\2\2\13\35+/\62\65<AHP";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}