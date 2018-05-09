package main.asw.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.asw.util.location.LatLng;

public class LatLngTest {

	@Test
	public void latLngTestNullLat() {
		new LatLng(0, 0);
		new LatLng(30, 150);
	}
	
	@Test
	public void latLngToStringTest() {
		double latitude = 15;
		double longitude = 15;
		LatLng ltlng = new LatLng(latitude, longitude);
		assertEquals("Location{Latitude='"+latitude+"',"+
				"Longitude='"+longitude+"'}", ltlng.toString());
	}
}
