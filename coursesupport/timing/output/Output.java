package timing.output;

import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvWriter;

import timing.utils.SizeAndLong;

public class Output {

	private CsvWriter w;

	public Output(String exper, String file) {
		this(exper,file, false);
	}
	public Output(String exper, String file, boolean append) {
		if (!file.endsWith(".csv")) {
			file    = file + ".csv";
		}
		try {
			FileWriter fw = new FileWriter("outputs/" + file, append);
			this.w  = new CsvWriter(fw, ',');
			w.write("n");
			w.write(exper);
			w.endRecord();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Write a series of sizes and times to an output file
	 * @param file filename to which the output should be appended
	 * @param exper column name
	 * @param iter iterator that returns the sizes and durations
	 */
	public void writeSizeTiming(Iterable<SizeAndLong> iter) {
		for (SizeAndLong st : iter) {
			writeSizeValue(st.size, st.value);
		}
	}

	public void writeSizeValue(int size, long value) {
		try {
			// System.out.println("writing " + size + " " + value);
			w.write("" + size);
			w.write("" + value);
			w.endRecord();
			w.flush();
		} catch (Throwable t) {
			throw new Error("oops");
		}

	}
	
	public void close() {
		w.close();
	}

}
