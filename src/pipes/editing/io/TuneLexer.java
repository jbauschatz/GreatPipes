// Generated from Tune.g4 by ANTLR 4.1

package pipes.editing.io;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TuneLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, TimeSignature=4, NOTENAME=5, NUMBER=6, EMBELLISHMENT=7, 
		WS=8, LINE=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'.'", "'-'", "'|'", "TimeSignature", "NOTENAME", "NUMBER", "EMBELLISHMENT", 
		"WS", "LINE"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "TimeSignature", "NOTENAME", "NUMBER", "EMBELLISHMENT", 
		"WS", "LINE"
	};


	public TuneLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tune.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\13S\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\6\7%\n\7\r\7\16\7"+
		"&\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bH\n\b\3\t"+
		"\6\tK\n\t\r\t\16\tL\3\n\5\nP\n\n\3\n\3\n\2\13\3\3\1\5\4\1\7\5\1\t\6\1"+
		"\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\3\2\4\5\2CCIIci\4\2\13\13\"\"^\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\27\3\2\2\2\7\31"+
		"\3\2\2\2\t\33\3\2\2\2\13!\3\2\2\2\r$\3\2\2\2\17G\3\2\2\2\21J\3\2\2\2\23"+
		"O\3\2\2\2\25\26\7\60\2\2\26\4\3\2\2\2\27\30\7/\2\2\30\6\3\2\2\2\31\32"+
		"\7~\2\2\32\b\3\2\2\2\33\34\7]\2\2\34\35\5\r\7\2\35\36\7\61\2\2\36\37\5"+
		"\r\7\2\37 \7_\2\2 \n\3\2\2\2!\"\t\2\2\2\"\f\3\2\2\2#%\4\62;\2$#\3\2\2"+
		"\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\16\3\2\2\2()\7)\2\2)H\7C\2\2*+\7)"+
		"\2\2+H\7I\2\2,-\7)\2\2-H\7f\2\2./\7)\2\2/H\7g\2\2\60\61\7f\2\2\61\62\7"+
		"d\2\2\62H\7n\2\2\63\64\7v\2\2\64\65\7j\2\2\65\66\7t\2\2\66H\7y\2\2\67"+
		"8\7d\2\289\7k\2\29:\7t\2\2:H\7n\2\2;<\7i\2\2<=\7t\2\2=>\7k\2\2>H\7r\2"+
		"\2?@\7v\2\2@A\7c\2\2AB\7q\2\2BH\7t\2\2CD\7e\2\2DE\7t\2\2EF\7w\2\2FH\7"+
		"p\2\2G(\3\2\2\2G*\3\2\2\2G,\3\2\2\2G.\3\2\2\2G\60\3\2\2\2G\63\3\2\2\2"+
		"G\67\3\2\2\2G;\3\2\2\2G?\3\2\2\2GC\3\2\2\2H\20\3\2\2\2IK\t\3\2\2JI\3\2"+
		"\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\22\3\2\2\2NP\7\17\2\2ON\3\2\2\2OP"+
		"\3\2\2\2PQ\3\2\2\2QR\7\f\2\2R\24\3\2\2\2\7\2&GLO";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}