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
		T__1=1, T__0=2, TEXT=3, TimeSignature=4, NOTENAME=5, NUMBER=6, TIE=7, 
		START_REPEAT=8, END_REPEAT=9, EMBELLISHMENT=10, WS=11, LINE=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'.'", "'|'", "TEXT", "TimeSignature", "NOTENAME", "NUMBER", "'-'", "'|:'", 
		"':|'", "EMBELLISHMENT", "WS", "LINE"
	};
	public static final String[] ruleNames = {
		"T__1", "T__0", "TEXT", "TimeSignature", "NOTENAME", "NUMBER", "TIE", 
		"START_REPEAT", "END_REPEAT", "EMBELLISHMENT", "WS", "LINE"
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\16o\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\7\4\"\n\4\f\4\16\4%\13\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\6\7\62\n\7\r\7\16\7\63\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13d\n\13\3\f\6\fg\n\f\r\f\16\fh\3\r\5\rl\n\r\3\r\3\r\2\16\3"+
		"\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r"+
		"\1\31\16\1\3\2\5\b\2\"\"..\60\60\62;C\\c|\5\2CCIIci\4\2\13\13\"\"}\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\3\33\3\2\2\2\5\35\3\2\2\2\7\37\3\2\2\2\t(\3\2\2\2\13.\3\2\2\2"+
		"\r\61\3\2\2\2\17\65\3\2\2\2\21\67\3\2\2\2\23:\3\2\2\2\25c\3\2\2\2\27f"+
		"\3\2\2\2\31k\3\2\2\2\33\34\7\60\2\2\34\4\3\2\2\2\35\36\7~\2\2\36\6\3\2"+
		"\2\2\37#\7]\2\2 \"\t\2\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&"+
		"\3\2\2\2%#\3\2\2\2&\'\7_\2\2\'\b\3\2\2\2()\7]\2\2)*\5\r\7\2*+\7\61\2\2"+
		"+,\5\r\7\2,-\7_\2\2-\n\3\2\2\2./\t\3\2\2/\f\3\2\2\2\60\62\4\62;\2\61\60"+
		"\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\16\3\2\2\2\65\66"+
		"\7/\2\2\66\20\3\2\2\2\678\7~\2\289\7<\2\29\22\3\2\2\2:;\7<\2\2;<\7~\2"+
		"\2<\24\3\2\2\2=>\7)\2\2>d\7C\2\2?@\7)\2\2@d\7I\2\2AB\7)\2\2Bd\7f\2\2C"+
		"D\7)\2\2Dd\7g\2\2EF\7f\2\2FG\7d\2\2Gd\7n\2\2HI\7v\2\2IJ\7j\2\2JK\7t\2"+
		"\2Kd\7y\2\2LM\7u\2\2MN\7v\2\2Nd\7t\2\2OP\7d\2\2PQ\7k\2\2QR\7t\2\2Rd\7"+
		"n\2\2ST\7i\2\2TU\7t\2\2UV\7k\2\2Vd\7r\2\2WX\7v\2\2XY\7c\2\2YZ\7q\2\2Z"+
		"d\7t\2\2[\\\7d\2\2\\]\7d\2\2]^\7n\2\2^d\7{\2\2_`\7e\2\2`a\7t\2\2ab\7w"+
		"\2\2bd\7p\2\2c=\3\2\2\2c?\3\2\2\2cA\3\2\2\2cC\3\2\2\2cE\3\2\2\2cH\3\2"+
		"\2\2cL\3\2\2\2cO\3\2\2\2cS\3\2\2\2cW\3\2\2\2c[\3\2\2\2c_\3\2\2\2d\26\3"+
		"\2\2\2eg\t\4\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\30\3\2\2\2j"+
		"l\7\17\2\2kj\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\7\f\2\2n\32\3\2\2\2\b\2#\63"+
		"chk";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}