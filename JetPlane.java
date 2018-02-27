public class JetPlane extends Aircraft implements IFlyaable{

	private WeatherTower weatherTower;

	private JetPlane(String name, Coordinates coordinates);
	public 	void updateConditions();
	public	void registerTover(WeatherTower weatherTower);
}