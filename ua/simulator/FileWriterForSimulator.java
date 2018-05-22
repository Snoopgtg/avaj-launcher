package ua.simulator;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class FileWriterForSimulator {

	private ArrayList<String> arrayForFile;
	private Path file;

	public FileWriterForSimulator() {
		try {
			this.arrayForFile = new ArrayList<String>();
			this.file = Paths.get("simulation.txt");
			Files.deleteIfExists(file);
			Files.createFile(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write() {
		try {

			Files.write(this.file, this.arrayForFile, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addDataToList(String textForFile) {
		
		this.arrayForFile.add(textForFile);
	}
}