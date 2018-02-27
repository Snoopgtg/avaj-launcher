public class Helicopter extends Aircraft implements IFlyable{

	private WeatherTower weatherTower;

	private Helicopter(String name, Coordinates coordinates);
	public 	void updateConditions();
	public	void registerTover(WeatherTower weatherTower);
}