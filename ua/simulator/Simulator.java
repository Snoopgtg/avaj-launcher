package ua.simulator;
import ua.aircraft.AircraftFactory;
import ua.aircraft.Flyable;
import ua.simulator.WeatherTower;
import ua.simulator.FileWriterForSimulator;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.io.File;
import java.util.Scanner;

public class Simulator {

	public static void main(String[] args) throws Exception {
		if (args.length != 1)
		{
			System.err.println("one and only one argument from the command line is available");
			System.exit(1);
		}
		int weatherCounter = 0;
		FileWriterForSimulator dataWriter = new FileWriterForSimulator();
		AircraftFactory aircraft = new AircraftFactory();
		WeatherTower weatherTower = new WeatherTower();
		try{
			File file = new File(args[0]);
			boolean firstLine = true;
			boolean dataIsPreset = false;
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String data = inputStream.nextLine();
				if (firstLine) {
					weatherCounter = positiveIntInspector(data);
					firstLine = false;
				}
				else {

					dataIsPreset = true;
					String[] results = data.split(" ");

					String typeFlyable = new String();
					String nameFlyable = new String();
					int[] coordinatesFlyable = new int[3];

					if (results.length != 5) {
						System.err.println("Each following line will be describes an aircraft"
							+ "that will be part of the simulation, with this format: "
							+ "TYPE NAME LONGITUDE LATITUDE HEIGHT.");
						System.exit(1);
					}
					for (int i = 0; i < results.length; i++) {
						String res = results[i];
						if (i == 0) {
							typeFlyable = res;
						}
						else if (i == 1) {
							nameFlyable = res;
						}
						else {
							coordinatesFlyable[i - 2] = positiveIntInspector(res);
						}
					}
					Flyable flyable = aircraft.newAircraft(typeFlyable, nameFlyable, coordinatesFlyable[0],
						coordinatesFlyable[1], coordinatesFlyable[2]);
					flyable.registerWriter(dataWriter);
					flyable.registerTower(weatherTower);					
				}
			}
			inputStream.close();
			if (!dataIsPreset) {
				System.err.println("Each following line will be describes an aircraft"
							+ "that will be part of the simulation, with this format: "
							+ "TYPE NAME LONGITUDE LATITUDE HEIGHT.");
				System.exit(1);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		while (weatherCounter > 0) {
			weatherTower.changeWeather();
			weatherCounter--;
		}
		dataWriter.write();		
	}

	public static int positiveIntInspector(String text) {

		if (!text.matches("^[\\d]*$")) {
			System.err.println("The first line of the file will be contains a positive integer number");
			System.exit(1);
		}

		try {
			return Integer.parseInt(text);
		} catch(NumberFormatException e) {
			throw new NumberFormatException("it's not Integer");	
		}
	}
}	
