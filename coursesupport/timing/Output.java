package timing;

import java.io.FileWriter;

import com.csvreader.CsvWriter;

public class Output {

	/**
	 * Write a series of sizes and times to an output file
	 * @param file filename to which the output should be appended
	 * @param exper column name
	 * @param iter iterator that returns the sizes and durations
	 */
	public static void writeSizeTiming(String file, String exper, Iterable<SizeAndTiming> iter) {
		try {
			if (!file.endsWith(".csv")) {
				file = file + ".csv";
			}
			FileWriter fw = new FileWriter(file, true);
			CsvWriter w = new CsvWriter(fw, ',');
			//
			// Write header row
			//
			w.write("size");
			w.write(exper);
			w.endRecord();
			//
			// and write the data
			//
			for (SizeAndTiming st : iter) {
				w.write(""+st.size);
				w.write(""+st.timing.toMillis());
				w.endRecord();
			}
			w.close();
		} catch (Throwable t) {
			System.out.println("Fail write with " + t);
		}
	}

}
