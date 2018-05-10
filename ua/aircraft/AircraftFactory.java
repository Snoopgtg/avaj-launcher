package ua.aircraft;

import ua.aircraft.*;
import ua.weather.Coordinates;

//import ua.aircraft.AircraftFactory;

public class AircraftFactory{

	public	Flyable newAircraft(String type, String name, int longitude,
								int latitude, int height){
		
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		switch (type.toLowerCase()) {

			case "jetplane" : return new JetPlane(name, coordinates);
			case "helicopter" : return new Helicopter(name, coordinates);
			case "baloon" : return new Baloon(name, coordinates);
			default : return null;//TODO правильно щось повурнути
		}

		/*if (type.toLowerCase().equals("jetplane"))
			return new JetPlane(name, coordinates);
		else if (type.toLowerCase().equals("helicopter"))
			return new Helicopter(name, coordinates);
		else if (type.toLowerCase().equals("baloon"))
			return new Baloon(name, coordinates);
		return NULL;*/
	}
}