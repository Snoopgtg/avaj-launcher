package ua.simulator;
import ua.aircraft.AircraftFactory;
//import ua.simulator.Tower;
import ua.aircraft.Flyable;
import ua.simulator.WeatherTower;

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
			System.out.println("one and only one argument from the command line is available");
			System.exit(1);
		}
		int weatherCounter = 0;
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
				/*String res;
				System.out.println(data);*/
				//regexChecker("^\\d+$", data);
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

					
					for (int i = 0; i < results.length; i++) {
						String res = results[i];
						//System.out.println("-----------------"+results[i]);
						if (i == 0)
						{
							System.out.println("type : " + res);
							typeAircraftInspector(res);
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
					//System.out.println("before AircraftFactory");
					Flyable flyable = aircraft.newAircraft(typeFlyable, nameFlyable, coordinatesFlyable[0],
										coordinatesFlyable[1], coordinatesFlyable[2]);
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
	}

	public static int positiveIntInspector(String text){

		if (!text.matches("^[\\d]*$"))
			{
				System.err.println("Cheking not digit");
				System.exit(1);
			}
		try {
			return Integer.parseInt(text);
		} catch(NumberFormatException e) {
			System.err.println("error_1");
			System.exit(1);
		}
		return 0;//TODO подумати що робити з цим
	}

	public static void typeAircraftInspector(String text){

		if (!text.matches("\\b(Baloon|JetPlane|Helicopter)"))
		{
			System.err.println("errorInTypeOfCrafts : " + text);
			System.exit(1);
		}
	}
	/*public static void regexChecker(String theRegex, String str2Check){

		System.out.println(theRegex);
		System.out.println(str2Check);
		Pattern checkRegex = Pattern.compile(theRegex);
		Matcher regexMatcher = checkRegex.matcher(str2Check);

		while (regexMatcher.find()){
			if (regexMatcher.group().length() != 0){
				System.out.println("TYT");
			}
		}
	}*/	
}	
