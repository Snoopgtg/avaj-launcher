package ua.aircraft;

import ua.simulator.WeatherTower;
import ua.aircraft.Aircraft;
import ua.aircraft.Flyable;
import ua.weather.Coordinates;

public class Baloon extends Aircraft implements Flyable{

	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates){

		super(name, coordinates);
	}
	
@Override
	public 	void updateConditions(){

		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		switch (weatherTower.getWeather(coordinates)){

			case ("SUN") : System.out.println("SUN");
				this.coordinates = new Coordinates(longitude + 2, latitude, height + 4);
			case ("RAIN") : System.out.println("RAIN");
				this.coordinates = new Coordinates(longitude + 5, latitude, height - 5);
			case ("FOG") : this.coordinates = new Coordinates(longitude + 1, latitude, height -3);
			case ("SNOW") : this.coordinates = new Coordinates(longitude, latitude, height - 15);
		}

		if (this.coordinates.getHeight() > 100)
			this.coordinates = new Coordinates(longitude, latitude, 100);
		if (this.coordinates.getHeight() <= 0)
		{
			this.weatherTower.unregister(this);
			System.out.println("Tower says: Baloon#" + name +
        				"(" + this.id + ") unregistered from weather tower.");
		}
	}

@Override
	public	void registerTower(WeatherTower weatherTower){

		this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Helicopter#" + name +
        				"(" + this.id + ") registered to weather tower.");
	}
}