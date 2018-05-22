package ua.simulator;
import ua.aircraft.AircraftFactory;
import ua.aircraft.Flyable;
import ua.simulator.WeatherTower;
import ua.simulator.FileWriterForSimulator;

import java.io.BufferedReader;//Scaner
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.io.File;
import java.util.Scanner;

public class Simulator{

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
			//BufferedReader reader = new BufferedReader(file);
			boolean firstLine = true;
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext())
			{
				String data = inputStream.nextLine();
				if (firstLine)
				{
						weatherCounter = positiveIntInspector(data);
						System.out.println("int_1 : " + data);

						firstLine = false;
				}
				else
				{
					String[] results = data.split(" ");

					String typeFlyable = new String();
					String nameFlyable = new String();
					int[] coordinatesFlyable = new int[3];

					if (results.length != 5)
					{
						System.err.println("the amount of data does not match 5");
						System.exit(1);
					}
					for (int i = 0; i < results.length; i++) {
						String res = results[i];
						if (i == 0)
						{
							typeFlyable = res;
						}
						else if (i == 1)
						{
							System.out.println("name : " + res);
							nameFlyable = res;
						}
						else
						{
							System.out.println("int_2 : " + res);
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
		}catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("before weatherCounter " + weatherCounter);

		while (weatherCounter > 0)
		{
			System.out.println("changeWeather_" + weatherCounter);
			weatherTower.changeWeather();
			weatherCounter--;
		}

		dataWriter.write();		
	}

	public static int positiveIntInspector(String text) {

		if (!text.matches("^[\\d]*$")) {
			System.err.println("Only positive number");
			System.exit(1);
		}

		try {
			return Integer.parseInt(text);
		} catch(NumberFormatException e) {
			throw new NumberFormatException("it's not Integer");	
		}
	}
}	
