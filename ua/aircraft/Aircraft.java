package ua.aircraft;

import ua.aircraft.Coordinates;

public class Aircraft{

	protected			long 		id;
	protected			String		name;
	protected			Coordinates coordinates;
	static private		long		idCounter;

	protected Aircraft(String name, Coordinates coordinates){

		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}
	private	long nextId(){

		return idCounter++; //перевірити чи правильно присвоюється
	}
}
