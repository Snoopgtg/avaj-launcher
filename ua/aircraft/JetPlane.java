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
@Override
	public 	void updateConditions(){

		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		switch (weatherTower.getWeather(coordinates)){

			case ("SUN") : System.out.println("SUN");
				//Coordinates coordinates = new Coordinates(longitude, latitude + 10, height + 2);//TODO зробити перевірку на крайні значення
			case ("RAIN") : System.out.println("RAIN");
		}
	/*	SUN - Latitude increases with 10, Height increases with 2
◦ RAIN - Latitude increases with 5
◦ FOG - Latitude increases with 1
◦ SNOW - Height decreases with 7*/
	}
	public	void registerTower(WeatherTower weatherTower){

		this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: JetPlane#" + name + "(" + this.id + ") registered to weather tower.");
	}
}