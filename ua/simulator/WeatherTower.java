package ua.simulator;

import ua.weather.Tower;
import ua.weather.Coordinates;
import ua.weather.WeatherProvider;

public class WeatherTower extends Tower{

	public String getWeather(Coordinates coordinates){

		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	public void changeWeather(){ // проверить по UML public 
		
		this.conditionsChanged();
	}
}