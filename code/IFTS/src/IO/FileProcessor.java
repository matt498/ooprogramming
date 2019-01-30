package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileProcessor {
	public static void copytxt(String src, String dst) throws IOException { 
		BufferedReader fr = new BufferedReader(new FileReader(src));
		BufferedWriter fw = new BufferedWriter(new FileWriter(dst));

		while(true) {
			String line = fr.readLine();
			if (line == null) break;
			fw.write(line);
		}

		fw.close();
		fr.close();
	}

	public static void copybin(String src, String dst) throws IOException { 
		BufferedInputStream fr;
		BufferedOutputStream fw;

		fr = new BufferedInputStream(new FileInputStream(src));
		fw = new BufferedOutputStream(new FileOutputStream(dst));

		while(true) {
			int b = fr.read();
			if (b == -1) break;
			fw.write(b);
		}
		fw.close();
		fr.close();
	}

	public static void main(String[] args) {
		String src = "/Users/nicola/Desktop/IMG.CR2";
		String dst = "/Users/nicola/Desktop/IMG.CR2.bak2";

		/*
		if (!(new File(src)).exists()) {
			System.out.println("src does not exist!");
			System.exit(0);
		}

		if ((new File(dst)).exists()) {
			System.out.println("dst does exist! Overwrite? ");
			Scanner scr = new Scanner(System.in);
			String reply = scr.nextLine();
			if (reply.equals("n"))
				System.exit(0);
		}
		 */

		long size = (long) (new File(src).length() / Math.pow(10, 6));
		System.out.println(size);

		System.out.println("Start...");
		long t1 = System.nanoTime();
		try {
			FileProcessor.copybin(src, dst);
		} catch (IOException e) {
			System.out.println("Error!!");
			System.exit(0);
		}
		long t2 = System.nanoTime();
		System.out.println("End...");
		System.out.println(size/((t2-t1)/Math.pow(10, 9)));

	}

}
