package ua.weather;

public class Coordinates{

	private int	longitude;
	private	int	latitude;
	private int	height;

	public Coordinates(int longitude, int latitude, int height){

        if (height > 100)
            height = 100;
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}
	public 	int getLongitude(){
		return longitude;
	}
	public 	int getLatitude(){
		return latitude;
	}
	public	int getHeight(){
		return height;
	}
}