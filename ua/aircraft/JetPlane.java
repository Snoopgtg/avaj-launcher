package ua.aircraft;

import ua.weather.WeatherTower;
import ua.aircraft.Aircraft;
import ua.aircraft.Flyable;
import ua.aircraft.Coordinates;

public class JetPlane extends Aircraft implements Flyable{

	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates){

		super(name, coordinates);
	}

	public 	void updateConditions(){

		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		switch (weatherTower.getWeather){

			case ("SUN") :
				Coordinates coordinates = new Coordinates(longitude, latitude + 10, height + 2);//TODO зробити перевірку на крайні значення
		}
	/*	SUN - Latitude increases with 10, Height increases with 2
◦ RAIN - Latitude increases with 5
◦ FOG - Latitude increases with 1
◦ SNOW - Height decreases with 7*/
	}
	public	void registerTower(WeatherTower weatherTower){

		this.weatherTower = weatherTower;
        this.weatherTower.register(this);
	}
}