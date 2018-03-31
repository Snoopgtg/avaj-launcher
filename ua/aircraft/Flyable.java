package ua.aircraft;

import ua.weather.WeatherTower;

public interface Flyable{

	public abstract void updateConditions();
	public abstract void registerTower(WeatherTower weatherTower);
}