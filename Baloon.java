public class Baloon extends Aircrafts implements IFlyable{

	private WeatherTower weatherTower;

	private Baloon(String name, Coordinates coordinates);
	public 	void updateConditions();
	public	void registerTover(WeatherTower weatherTower);
}