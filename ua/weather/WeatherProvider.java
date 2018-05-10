package ua.weather;

import ua.weather.Coordinates;

public class WeatherProvider{

	private static WeatherProvider weatherProvider = new WeatherProvider();
	private	static String[]		weather = {	"RAIN",
											"FOG",
											"SUN",
											"SNOW"};										;

	private	WeatherProvider(){

	}
	public static WeatherProvider getProvider(){

		return WeatherProvider.weatherProvider;
	}
	public String getCurrentWeather(Coordinates coordinates){

		int res;
		res = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
		return	this.weather[(res + 1) % 4];
	}
	
}