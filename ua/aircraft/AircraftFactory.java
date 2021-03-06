package ua.aircraft;

import ua.aircraft.*;
import ua.weather.Coordinates;

public class AircraftFactory {

	public	Flyable newAircraft(String type, String name, int longitude,
		int latitude, int height) {
		
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		switch (type.toLowerCase()) {

			case "jetplane" : return new JetPlane(name, coordinates);
			case "helicopter" : return new Helicopter(name, coordinates);
			case "baloon" : return new Baloon(name, coordinates);
			default : throw new Error(type + " is not valid aircraft");
		}
	}
}