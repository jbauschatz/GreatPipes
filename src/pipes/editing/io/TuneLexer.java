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
		T__2=1, T__1=2, T__0=3, TEXT=4, TimeSignature=5, NOTENAME=6, NUMBER=7, 
		EMBELLISHMENT=8, WS=9, LINE=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'.'", "'-'", "'|'", "TEXT", "TimeSignature", "NOTENAME", "NUMBER", "EMBELLISHMENT", 
		"WS", "LINE"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "TEXT", "TimeSignature", "NOTENAME", "NUMBER", 
		"EMBELLISHMENT", "WS", "LINE"
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\fa\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\7\5 \n\5\f\5\16\5#\13\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\6\b\60\n\b\r\b\16\b\61\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tV\n\t\3\n\6"+
		"\nY\n\n\r\n\16\nZ\3\13\5\13^\n\13\3\13\3\13\2\f\3\3\1\5\4\1\7\5\1\t\6"+
		"\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\3\2\5\b\2\"\"..\60\60\62"+
		";C\\c|\5\2CCIIci\4\2\13\13\"\"n\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\31\3\2\2\2\7\33\3\2\2\2\t\35\3\2\2\2"+
		"\13&\3\2\2\2\r,\3\2\2\2\17/\3\2\2\2\21U\3\2\2\2\23X\3\2\2\2\25]\3\2\2"+
		"\2\27\30\7\60\2\2\30\4\3\2\2\2\31\32\7/\2\2\32\6\3\2\2\2\33\34\7~\2\2"+
		"\34\b\3\2\2\2\35!\7]\2\2\36 \t\2\2\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2"+
		"\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\7_\2\2%\n\3\2\2\2&\'\7]\2\2\'(\5"+
		"\17\b\2()\7\61\2\2)*\5\17\b\2*+\7_\2\2+\f\3\2\2\2,-\t\3\2\2-\16\3\2\2"+
		"\2.\60\4\62;\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\20"+
		"\3\2\2\2\63\64\7)\2\2\64V\7C\2\2\65\66\7)\2\2\66V\7I\2\2\678\7)\2\28V"+
		"\7f\2\29:\7)\2\2:V\7g\2\2;<\7f\2\2<=\7d\2\2=V\7n\2\2>?\7v\2\2?@\7j\2\2"+
		"@A\7t\2\2AV\7y\2\2BC\7u\2\2CD\7v\2\2DV\7t\2\2EF\7d\2\2FG\7k\2\2GH\7t\2"+
		"\2HV\7n\2\2IJ\7i\2\2JK\7t\2\2KL\7k\2\2LV\7r\2\2MN\7v\2\2NO\7c\2\2OP\7"+
		"q\2\2PV\7t\2\2QR\7e\2\2RS\7t\2\2ST\7w\2\2TV\7p\2\2U\63\3\2\2\2U\65\3\2"+
		"\2\2U\67\3\2\2\2U9\3\2\2\2U;\3\2\2\2U>\3\2\2\2UB\3\2\2\2UE\3\2\2\2UI\3"+
		"\2\2\2UM\3\2\2\2UQ\3\2\2\2V\22\3\2\2\2WY\t\4\2\2XW\3\2\2\2YZ\3\2\2\2Z"+
		"X\3\2\2\2Z[\3\2\2\2[\24\3\2\2\2\\^\7\17\2\2]\\\3\2\2\2]^\3\2\2\2^_\3\2"+
		"\2\2_`\7\f\2\2`\26\3\2\2\2\b\2!\61UZ]";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}