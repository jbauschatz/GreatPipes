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
		T__2=1, T__1=2, T__0=3, TimeSignature=4, NOTENAME=5, NUMBER=6, EMBELLISHMENT=7, 
		WS=8, LINE=9;
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "'-'", "'|'", "TimeSignature", "NOTENAME", "NUMBER", 
		"EMBELLISHMENT", "WS", "LINE"
	};
	public static final int
		RULE_tune = 0, RULE_line = 1, RULE_measure = 2, RULE_melodyElement = 3, 
		RULE_note = 4;
	public static final String[] ruleNames = {
		"tune", "line", "measure", "melodyElement", "note"
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
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public List<TerminalNode> LINE() { return getTokens(TuneParser.LINE); }
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
			setState(15);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(10); line();
					setState(11); match(LINE);
					}
					} 
				}
				setState(17);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(18); line();
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
		enterRule(_localctx, 2, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20); measure();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << TimeSignature) | (1L << NOTENAME) | (1L << EMBELLISHMENT) | (1L << WS))) != 0) );
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
		enterRule(_localctx, 4, RULE_measure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_la = _input.LA(1);
			if (_la==TimeSignature) {
				{
				setState(25); match(TimeSignature);
				}
			}

			setState(29);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(28); match(WS);
				}
				break;
			}
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOTENAME || _la==EMBELLISHMENT) {
				{
				{
				setState(31); melodyElement();
				setState(32); match(WS);
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(39); match(WS);
				}
			}

			setState(42); match(3);
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
		enterRule(_localctx, 6, RULE_melodyElement);
		try {
			setState(46);
			switch (_input.LA(1)) {
			case EMBELLISHMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(44); match(EMBELLISHMENT);
				}
				break;
			case NOTENAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(45); note();
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
		enterRule(_localctx, 8, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(NOTENAME);
			setState(49); match(2);
			setState(50); match(NUMBER);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(51); match(1);
				}
				}
				setState(56);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\13<\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\7\2\20\n\2\f\2\16\2\23\13\2\3\2"+
		"\3\2\3\3\6\3\30\n\3\r\3\16\3\31\3\4\5\4\35\n\4\3\4\5\4 \n\4\3\4\3\4\3"+
		"\4\7\4%\n\4\f\4\16\4(\13\4\3\4\5\4+\n\4\3\4\3\4\3\5\3\5\5\5\61\n\5\3\6"+
		"\3\6\3\6\3\6\7\6\67\n\6\f\6\16\6:\13\6\3\6\2\7\2\4\6\b\n\2\2>\2\21\3\2"+
		"\2\2\4\27\3\2\2\2\6\34\3\2\2\2\b\60\3\2\2\2\n\62\3\2\2\2\f\r\5\4\3\2\r"+
		"\16\7\13\2\2\16\20\3\2\2\2\17\f\3\2\2\2\20\23\3\2\2\2\21\17\3\2\2\2\21"+
		"\22\3\2\2\2\22\24\3\2\2\2\23\21\3\2\2\2\24\25\5\4\3\2\25\3\3\2\2\2\26"+
		"\30\5\6\4\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32"+
		"\5\3\2\2\2\33\35\7\6\2\2\34\33\3\2\2\2\34\35\3\2\2\2\35\37\3\2\2\2\36"+
		" \7\n\2\2\37\36\3\2\2\2\37 \3\2\2\2 &\3\2\2\2!\"\5\b\5\2\"#\7\n\2\2#%"+
		"\3\2\2\2$!\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'*\3\2\2\2(&\3\2\2\2"+
		")+\7\n\2\2*)\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\7\5\2\2-\7\3\2\2\2.\61\7\t"+
		"\2\2/\61\5\n\6\2\60.\3\2\2\2\60/\3\2\2\2\61\t\3\2\2\2\62\63\7\7\2\2\63"+
		"\64\7\4\2\2\648\7\b\2\2\65\67\7\3\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3"+
		"\2\2\289\3\2\2\29\13\3\2\2\2:8\3\2\2\2\n\21\31\34\37&*\608";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}