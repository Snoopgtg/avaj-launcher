package ua.simulator;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class FileWriterForSimulator {

	private ArrayList<String> arrayForFile;
	private Path file;

	public FileWriterForSimulator() {
		// try {
			this.arrayForFile = new ArrayList<String>();
			this.file = Paths.get("test1.txt");

		// } catch (IOException e) {
		// 	e.printStackTrace();
		// }
	}

	public void write() {
		try {

			Files.write(this.file, this.arrayForFile, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void addDataToList(String textForFile) {

		System.out.println("---> " + textForFile);
		// this.arrayForFile.add(textForFile);

	}
}