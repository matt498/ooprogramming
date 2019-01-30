package Examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWriter {

	public String read(String filename) throws IOException {
		FileReader in = new FileReader(filename);;
		StringWriter out = new StringWriter();
		int c;

		while ((c = in.read()) != -1) {
			out.write(c);
		}
		return out.toString();
	}
	
	public void write(String filename, String content) throws IOException {
		StringReader in = new StringReader(content);
		FileWriter out = new FileWriter(filename);
		int c;

		while ((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		StringReaderWriter srw = new StringReaderWriter();
		System.out.println("Reading file...");
		String s = srw.read("webpage.html");
		System.out.println("Writing file...");
		srw.write("webpage.html.bak", s);
	}

}
