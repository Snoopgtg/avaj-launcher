package ua.aircraft;

import ua.simulator.WeatherTower;
import ua.aircraft.Aircraft;
import ua.aircraft.Flyable;
import ua.weather.Coordinates;
import ua.simulator.FileWriterForSimulator;

public class Helicopter extends Aircraft implements Flyable{

	private WeatherTower weatherTower;
	private FileWriterForSimulator fileWriterForSimulator;

	public Helicopter(String name, Coordinates coordinates) {

		super(name, coordinates);
	}

@Override
	public 	void updateConditions() {

		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		switch (weatherTower.getWeather(this.coordinates)) {

			case ("SUN") : this.fileWriterForSimulator.addDataToList("Helicopter#" + name +
				"(" + this.id + "): It's time for adveture.");
			this.coordinates = new Coordinates(longitude + 10, latitude, height + 2);
			break;
			case ("RAIN") : this.fileWriterForSimulator.addDataToList("Helicopter#" + name +
				"(" + this.id + "): Where is my umbrella.");
			this.coordinates = new Coordinates(longitude + 5, latitude, height);
			break;
			case ("FOG") : this.fileWriterForSimulator.addDataToList("Helicopter#" + name +
				"(" + this.id + "): Let us go in; fog is rising.");
			this.coordinates = new Coordinates(longitude + 1, latitude, height);
			break;
			case ("SNOW") : this.fileWriterForSimulator.addDataToList("Helicopter#" + name +
				"(" + this.id + "): Winter is coming.");
			this.coordinates = new Coordinates(longitude, latitude, height - 12);
			break;
		}

		if (this.coordinates.getHeight() <= 0)
		{
			this.weatherTower.unregister(this);
			this.fileWriterForSimulator.addDataToList("Helicopter#" + name +
				"(" + this.id + ") I'm landing.");
			this.fileWriterForSimulator.addDataToList("Tower says: Helicopter#" + name +
				"(" + this.id + ") unregistered from weather tower.");
		}
	}

	@Override
	public	void registerTower(WeatherTower weatherTower) {

		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		this.fileWriterForSimulator.addDataToList("Tower says: Helicopter#" + name +
			"(" + this.id + ") registered to weather tower.");
	}


@Override	
	public	void registerWriter(FileWriterForSimulator fileWriterForSimulator) {

		this.fileWriterForSimulator = fileWriterForSimulator;

	}
}