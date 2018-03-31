package ua.weather;

import ua.weather.Tower;
import ua.aircraft.Coordinates;
//import ua.weather.WeatherProvider;

public class WeatherTower extends Tower{

	public String getWeather(Coordinates coordinates){

		return "Tanya";//WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	private void changeWeather(){

		this.changeWeather();
	}
}