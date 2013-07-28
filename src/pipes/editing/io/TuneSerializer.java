package pipes.editing.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import pipes.editing.io.TuneParser.LineContext;
import pipes.editing.io.TuneParser.MeasureContext;
import pipes.editing.io.TuneParser.MelodyElementContext;
import pipes.editing.io.TuneParser.TuneContext;
import pipes.model.Line;
import pipes.model.Measure;
import pipes.model.Note;
import pipes.model.TimeSignature;
import pipes.model.Tune;
import pipes.model.embellishment.EmbellishmentFamily;

public class TuneSerializer {
	public static final String FILE_EXTENSION = "grp";
	
	public static void main(String... args) {
		//loadTune(new File("C:\\Users\\jbauscha\\workspace\\Pipes\\tunes\\test.grp"));
	}
	
	public static File saveTune(Tune t, File f) throws IOException {
		File savedFile = f;
		if (!f.getName().endsWith("." + FILE_EXTENSION))
			savedFile = new File(f.getAbsolutePath() + "." + FILE_EXTENSION);
		
		try (FileWriter w = new FileWriter(savedFile)) {
			boolean firstLine = true;
			for (Line l : t) {
				if (!firstLine)
					w.write("\n");
				firstLine = false;
	
				for (Measure m : l) {
					boolean firstInMeasure = true;
					if (m.isTimeSignatureChange()) {
						w.write("[" + m.getTimeSignature() + "]");
						firstInMeasure = false;
					}
					
					for (Note n : m) {
						if (!firstInMeasure)
							w.write(" ");
						firstInMeasure = false;
	
						if (n.hasEmbellishment())
							w.write(n.getEmbellishmentFamily().getShortName() + " ");
						w.write(n.getPitch().shortName+"-"+n.getBeatDivision().denominator);
						for (int i = 0; i<n.getNumDots(); ++i)
							w.write(".");
					}
					
					w.write(" |");
				}
			}
		}
		
		return savedFile;
	}
	
	public static Tune loadTune(File f) throws IOException {
		CharStream stream = new ANTLRFileStream(f.getAbsolutePath());
		TuneLexer lexer = new TuneLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TuneParser parser = new TuneParser(tokens);

		Tune tune = new Tune();
		TuneContext tuneContext = parser.tune();
		TimeSignature currentTime = null;
		EmbellishmentFamily family = null;
		for (LineContext l : tuneContext.line()) {
			Line tuneLine = new Line();
			tune.add(tuneLine);
			for (MeasureContext m : l.measure()) {
				Measure tuneMeasure;
				if (m.TimeSignature() == null) {
					tuneMeasure = new Measure(currentTime);
				} else {
					currentTime = TimeSignature.fromString(m.TimeSignature().getText());
					tuneMeasure = new Measure(currentTime);
					tuneMeasure.setIsTimeSignatureChange(true);
				}
				tuneLine.add(tuneMeasure);
				for (MelodyElementContext me : m.melodyElement()) {
					if (me.EMBELLISHMENT() != null) {
						family = EmbellishmentFamily.getByName(me.EMBELLISHMENT().getText());
					} else if (me.note() != null) {
						Note n = Note.fromString(tune, me.note().getText());
						tuneMeasure.addNote(n);
						
						if (family != null)
							n.setEmbellishmentFamily(family);
						
						family = null;
					}
				}
			}
		}
		
		return tune;
	}
	
	public static Tune parseTune(Scanner s) {
		Tune t = new Tune();
		
		return t;
	}
}
