package pipes.view;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import pipes.model.Tune;

public class PrintController {
	private PrintController() {
	}
	
	public static void print(Tune tune) throws PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(new TunePrintRenderer(tune));
		if (job.printDialog()) {
			job.print();
		}
	}
}
