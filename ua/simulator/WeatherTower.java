package ua.simulator;

import ua.weather.Tower;
import ua.weather.Coordinates;
import ua.weather.WeatherProvider;

public class WeatherTower extends Tower{

	public String getWeather(Coordinates coordinates){

		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	public void changeWeather(){
		//TODO потрібно прибрати public, але потім при компіляції видає помилку cannot be accessed from outside package weatherTower.changeWeather();

		this.conditionsChanged();
	}
}