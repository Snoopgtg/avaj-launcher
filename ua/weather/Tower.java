package ua.weather;

import ua.aircraft.Flyable;
import java.util.*;

public class Tower{

	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable){

		if (observers.contains(flyable))
			return;
		observers.add(flyable);
	}
	public void unregister(Flyable flyable){

		if (observers.size() == 0)
			return;
		observers.remove(flyable);
		System.out.println("Tower says: Baloon#B1(1) unregistered to weather tower.");
	}
	protected void conditionsChanged(){

		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
	}
}