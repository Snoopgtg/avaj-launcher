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
			// https://habr.com/company/golovachcourses/blog/223821/ вот тут почти в начале про использование System.err,
            // а не out, тебе думаю будет интересно
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
				    // чтобы решить проблему с todo которая кстати возвращает у тебя 0, а positive integer number - это 1, 2, 3 ...
                    // стоит не делать System.exit(0); а бросать адекватную ошибку
                    // throw new IllegalArgumentException("This String" + yourString + "is not a positive integer");
                    // посомтри вот тут: https://habr.com/company/golovachcourses/blog/223821/ (в поиске по странице: IllegalArgumentException)
						weatherCounter = positiveIntInspector(data); // weatherChangeCounter тогда

                        System.out.println("weatherChangeCounter: " + data);

						firstLine = false;
				}
				else
				{
					String[] describeAircraft = data.split(" ");

					String typeFlyable = new String();
					String nameFlyable = new String();
					int[] coordinatesFlyable = new int[3];

					// вот тут место где можно было бы сделать проверку на то, что в линии достаточно инфы
                    // describeAircraft.length обязательно 5
					for (int i = 0; i < describeAircraft.length; i++) {
						String res = describeAircraft[i];
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

                    // просто для читаемости кода все-таки стоило бы добавить:
                    // int longitude = coordinatesFlyable[0] ...
                    // int latitude = coordinatesFlyable[1]
                    // aircraft.newAircraft(typeFlyable, nameFlyable, longitude, latitude, heigh);
					Flyable flyable = aircraft.newAircraft(typeFlyable, nameFlyable, coordinatesFlyable[0],
										coordinatesFlyable[1], coordinatesFlyable[2]);

					flyable.registerTower(weatherTower);
				}
			}

			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (weatherCounter > 0)
		{
		    // возможно имеет смысл не прогонять weatherCounter если observers пустой
			System.out.println("changeWeather_" + weatherCounter);
			weatherTower.changeWeather();
			weatherCounter--;
		}
	}

	public static int positiveIntInspector(String text) {

        if (!text.matches("^[\\d]*$")) {
            // может лучше так: This String is not a positive digit: /значение/
            System.err.println("Cheking not digit");
            System.exit(1);
        }

        // получается что try catch тут бессмысленный, у тебя проходят проверку только числа 0, 1, 2 ..
        try {
           return  Integer.parseInt(text);
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
