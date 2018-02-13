package main.asw.location;

import main.asw.util.Checker;

/**
 * 
 * @author Sergio Faya Fernández
 *
 */
public class LatLng {

	public long latitude;
	public long longitude;
	
	public LatLng(long latitude, long longitude) {
		Checker.isNull(latitude);
		Checker.isNull(longitude);
		this.latitude = latitude;
		this.longitude = longitude;
	}
}
