// Generated from Tune.g4 by ANTLR 4.1

package pipes.editing.io;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TuneParser}.
 */
public interface TuneListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TuneParser#melodyElement}.
	 * @param ctx the parse tree
	 */
	void enterMelodyElement(@NotNull TuneParser.MelodyElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuneParser#melodyElement}.
	 * @param ctx the parse tree
	 */
	void exitMelodyElement(@NotNull TuneParser.MelodyElementContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuneParser#author}.
	 * @param ctx the parse tree
	 */
	void enterAuthor(@NotNull TuneParser.AuthorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuneParser#author}.
	 * @param ctx the parse tree
	 */
	void exitAuthor(@NotNull TuneParser.AuthorContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuneParser#measure}.
	 * @param ctx the parse tree
	 */
	void enterMeasure(@NotNull TuneParser.MeasureContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuneParser#measure}.
	 * @param ctx the parse tree
	 */
	void exitMeasure(@NotNull TuneParser.MeasureContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuneParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(@NotNull TuneParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuneParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(@NotNull TuneParser.NameContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuneParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(@NotNull TuneParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuneParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(@NotNull TuneParser.LineContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuneParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull TuneParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuneParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull TuneParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuneParser#tune}.
	 * @param ctx the parse tree
	 */
	void enterTune(@NotNull TuneParser.TuneContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuneParser#tune}.
	 * @param ctx the parse tree
	 */
	void exitTune(@NotNull TuneParser.TuneContext ctx);

	/**
	 * Enter a parse tree produced by {@link TuneParser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(@NotNull TuneParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TuneParser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(@NotNull TuneParser.NoteContext ctx);
}