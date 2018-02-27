public class WeatherProvider{

	private WeatherProvider weatherProvider;
	private	string			weather;

	private	WeatherProvider();
	public	WeatherProvider getProvider();
	public	String getCurretnWeather(Coordinates coordinates);
	
}