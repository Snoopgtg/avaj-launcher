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

			case ("SUN") : System.out.println("Baloon#" + name +
        				"(" + this.id + "): It's so hot we need ice cream.");
				this.coordinates = new Coordinates(longitude + 2, latitude, height + 4);
				break;
			case ("RAIN") : System.out.println("Baloon#" + name +
        				"(" + this.id + "): It's raining cats and dogs.");
				this.coordinates = new Coordinates(longitude + 5, latitude, height - 5);
				break;
			case ("FOG") : System.out.println("Baloon#" + name +
        					"(" + this.id + "): keep calm and fog.");
				this.coordinates = new Coordinates(longitude + 1, latitude, height -3);
				break;
			case ("SNOW") : System.out.println("Baloon#" + name +
        					"(" + this.id + "): freezing cold like a fridge.");
				this.coordinates = new Coordinates(longitude, latitude, height - 15);
				break;
		}

		if (this.coordinates.getHeight() > 100)
			this.coordinates = new Coordinates(longitude, latitude, 100);
		if (this.coordinates.getHeight() <= 0)
		{
			this.weatherTower.unregister(this);
			System.out.println("Baloon#" + name +
        				"(" + this.id + ") I'm landing.");
			System.out.println("Tower says: Baloon#" + name +
        				"(" + this.id + ") unregistered from weather tower.");
		}
	}

@Override
	public	void registerTower(WeatherTower weatherTower){

		this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Baloon#" + name +
        				"(" + this.id + ") registered to weather tower.");
	}
}

/*case ("SUN") : System.out.println("Baloon#" + name +
        				"(" + this.id + "): It's so hot we need ice cream.");
				this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
				break;
			case ("RAIN") : System.out.println("Baloon#" + name +
        				"(" + this.id + "): It's raining cats and dogs.");
				this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight() - 5);
				break;
			case ("FOG") : System.out.println("Baloon#" + name +
        					"(" + this.id + "): keep calm and fog.");
				this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight() -3);
				break;
			case ("SNOW") : System.out.println("Baloon#" + name +
        					"(" + this.id + "): freezing cold like a fridge.");
				this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
				break;
		}

		if (this.coordinates.getHeight() > 100)
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);*/