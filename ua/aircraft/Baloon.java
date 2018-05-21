package ua.aircraft;

/*import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;*/
import ua.simulator.WeatherTower;
import ua.aircraft.Aircraft;
import ua.aircraft.Flyable;
import ua.weather.Coordinates;
import ua.simulator.FileWriterForSimulator;

public class Baloon extends Aircraft implements Flyable{

	private WeatherTower weatherTower;
	private FileWriterForSimulator fileWriterForSimulator;

	public Baloon(String name, Coordinates coordinates){

		super(name, coordinates);
	}
	
@Override
	public 	void updateConditions(){

		/*PrintWriter writer = new PrintWriter("simulation.txt", "UTF-8");
		writer.println("The first line");
		writer.println("The second line");
		writer.close();*/
		// try {
		// 	File file = new File("test1.txt");
			// FileWriter Files = new FileWriter(file);
			//Path file = Paths.get("test1.txt");

			// ArrayList<String> textForFile = new ArrayList<String>();
			int longitude = this.coordinates.getLongitude();
			int latitude = this.coordinates.getLatitude();
			int height = this.coordinates.getHeight();
			switch (weatherTower.getWeather(this.coordinates)){

				case ("SUN") : this.fileWriterForSimulator.addDataToList("Baloon#" + name +
					"(" + this.id + "): It's so hot we need ice cream.");
				this.coordinates = new Coordinates(longitude + 2, latitude, height + 4);
				// Files.write(file, textForFile, Charset.forName("UTF-8"));
				break;
				case ("RAIN") : this.fileWriterForSimulator.addDataToList("Baloon#" + name +
					"(" + this.id + "): It's raining cats and dogs.");
				this.coordinates = new Coordinates(longitude, latitude, height - 5);
				// Files.write(file, textForFile, Charset.forName("UTF-8"));
				break;
				case ("FOG") : this.fileWriterForSimulator.addDataToList("Baloon#" + name +
					"(" + this.id + "): keep calm and fog.");
				this.coordinates = new Coordinates(longitude, latitude, height -3);
				// Files.write(file, textForFile, Charset.forName("UTF-8"));
				break;
				case ("SNOW") : this.fileWriterForSimulator.addDataToList("Baloon#" + name +
					"(" + this.id + "): freezing cold like a fridge.");
				this.coordinates = new Coordinates(longitude, latitude, height - 15);
				// Files.write(file, textForFile, Charset.forName("UTF-8"));
				break;
			}

			if (this.coordinates.getHeight() <= 0)
			{
				this.weatherTower.unregister(this);
				this.fileWriterForSimulator.addDataToList("Baloon#" + name +
					"(" + this.id + ") I'm landing.");
				this.fileWriterForSimulator.addDataToList("Tower says: Baloon#" + name +
					"(" + this.id + ") unregistered from weather tower.");
			}


			// Files.write(file, textForFile, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		// } catch (IOException e) {
		// 	e.printStackTrace();

		// }
	}

@Override
	public	void registerTower(WeatherTower weatherTower){

		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		this.fileWriterForSimulator.addDataToList("Tower says: Baloon#" + name +
			"(" + this.id + ") registered to weather tower.");
	}

@Override	
	public	void registerWriter(FileWriterForSimulator fileWriterForSimulator){

		this.fileWriterForSimulator = fileWriterForSimulator;
       
	}
}