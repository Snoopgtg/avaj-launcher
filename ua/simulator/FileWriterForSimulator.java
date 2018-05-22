package ua.simulator;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class FileWriterForSimulator {

	private ArrayList<String> arrayForFile;
	private Path file;
	PrintWriter writer;

	public FileWriterForSimulator() {
		 try {
			this.arrayForFile = new ArrayList<String>();
			this.file = Paths.get("simulation.txt");
			Files.deleteIfExists(file);
            Files.createFile(file);
			//writer = new PrintWriter("the-file-name.txt", "UTF-8");
			//Files.createFile("test.txt", 1);

		 } catch (IOException e) {
		 	e.printStackTrace();
		 }
	}

	public void write() {
		try {

			//this.writer.println(this.arrayForFile);
			Files.write(this.file, this.arrayForFile, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void addDataToList(String textForFile) {

		System.out.println("---> " + textForFile);
		this.arrayForFile.add(textForFile);
		//this.writer.println(textForFile);

	}
}