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
	}
	protected void conditionsChanged(){
		int numberOfObservers = observers.size();
		for (int i = 0; i < observers.size(); i++) {

			System.out.println("i = " + i);
			System.out.println("observer_" + observers.get(i));
			observers.get(i).updateConditions();

			if (numberOfObservers != observers.size()){
				i--;
				numberOfObservers = observers.size();
			}
			//TODO при визові unregister, удалаеться один лемент і observers.size
			//стає меншим на одиницю відповідно один алемент не показується
		}
	}
}