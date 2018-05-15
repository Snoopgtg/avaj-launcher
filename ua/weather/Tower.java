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

	// интересно, а ведь должно быть какое-то еще решения для такого эффекта
	protected void conditionsChanged(){

		int o = observers.size();
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions(); // запушила со своим сценарием, в котором при твоем решении
			// не выводилось последнее значение, если предпоследний убирался из массива

			if (o != observers.size()){
				i--;
				o = observers.size();
			}
			//TODO при визові unregister, удалаеться один лемент і observers.size
			//стає меншим на одиницю відповідно один алемент не показується
		}
	}
}