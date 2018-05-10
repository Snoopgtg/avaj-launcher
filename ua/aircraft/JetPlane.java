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

			case ("SUN") : System.out.println("JetPlane#" + name +
        				"(" + this.id + "): It's time to sunbathe.");
				this.coordinates = new Coordinates(longitude, latitude + 10, height + 2);
				break;
			case ("RAIN") : System.out.println("JetPlane#" + name +
        				"(" + this.id + "): It seems the rain begins.");
				this.coordinates = new Coordinates(longitude, latitude + 5, height);
				break;
			case ("FOG") : System.out.println("JetPlane#" + name +
        				"(" + this.id + "): It's a fog that is still hanging out over the city.");
				this.coordinates = new Coordinates(longitude, latitude + 1, height);
				break;
			case ("SNOW") : System.out.println("JetPlane#" + name +
        				"(" + this.id + "): Soon on skis.");
				this.coordinates = new Coordinates(longitude, latitude, height - 7);
				break;
		}

		if (this.coordinates.getHeight() > 100)
			this.coordinates = new Coordinates(longitude, latitude, 100);
		if (this.coordinates.getHeight() <= 0)
		{
			this.weatherTower.unregister(this);
			System.out.println("JetPlane#" + name +
        				"(" + this.id + ") I'm landing.");
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