package ua.weather;

import ua.weather.Coordinates;

public class WeatherProvider{

	private WeatherProvider weatherProvider = new WeatherProvider();
	private	String[]		weather = {	"RAIN",
										"FOG",
										"SUN",
										"SNOW"};										;

	private	WeatherProvider(){

	}
	public	WeatherProvider getProvider(){

		return weatherProvider;
	}
	public	String getCurrentWeather(Coordinates coordinates){

		int res;
		res = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
		return	this.weather[(res + 1) % 4];
	}
	
}