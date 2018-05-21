package ua.aircraft;

import ua.simulator.WeatherTower;
import ua.simulator.FileWriterForSimulator;

public interface Flyable{

	public abstract void updateConditions();
	public abstract void registerTower(WeatherTower weatherTower);
	public abstract void registerWriter(FileWriterForSimulator fileWriterForSimulator);
}