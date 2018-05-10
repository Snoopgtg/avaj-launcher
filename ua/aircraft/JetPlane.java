package ua.aircraft;

import ua.simulator.WeatherTower;
import ua.aircraft.Aircraft;
import ua.aircraft.Flyable;
import ua.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable{

	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates){

		super(name, coordinates);
	}
@Override
	public 	void updateConditions(){

		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		switch (weatherTower.getWeather(coordinates)){

			case ("SUN") : System.out.println("SUN");
				this.coordinates = new Coordinates(longitude, latitude + 10, height + 2);
			case ("RAIN") : System.out.println("RAIN");
				this.coordinates = new Coordinates(longitude, latitude + 5, height);
			case ("FOG") : this.coordinates = new Coordinates(longitude, latitude + 1, height);
			case ("SNOW") : this.coordinates = new Coordinates(longitude, latitude, height - 7);
		}

		if (this.coordinates.getHeight() > 100)
			this.coordinates = new Coordinates(longitude, latitude, 100);
		if (this.coordinates.getHeight() <= 0)
		{
			this.weatherTower.unregister(this);
			System.out.println("Tower says: JetPlane#" + name +
        				"(" + this.id + ") unregistered from weather tower.");
		}

	}

@Override	
	public	void registerTower(WeatherTower weatherTower){

		this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: JetPlane#" + name +
        				"(" + this.id + ") registered to weather tower.");
	}
}