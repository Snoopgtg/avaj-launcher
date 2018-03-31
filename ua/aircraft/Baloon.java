package ua.aircraft;

import ua.weather.WeatherTower;
import ua.aircraft.Aircraft;
import ua.aircraft.Flyable;
import ua.aircraft.Coordinates;

public class Baloon extends Aircraft implements Flyable{

	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates){

		super(name, coordinates);
	};
	
	public 	void updateConditions() {

	};

	public	void registerTower(WeatherTower weatherTower) {

	};
}