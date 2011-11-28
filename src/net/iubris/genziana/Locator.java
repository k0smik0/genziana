package net.iubris.genziana;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.inject.Inject;

public class Locator implements LocationListener {
	
	@Inject 
	private LocationManager locationManager;
	private Location location;
	
	public Locator() {
		register();
	}
	
	public void registerGPS(){
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0, 0, this);
	}	
	public void registerNetwork(){
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0, 0, this);
	}
	
	public void register(){
		registerGPS();
		registerNetwork();
	}
	
	public void unregister() {
		locationManager.removeUpdates(this);
	}

	public Location getLocation() {		
		return location;
	}

	@Override
	public void onLocationChanged(Location location) {
		this.location = location;
	}

	@Override
	public void onProviderDisabled(String provider) {	}
	@Override
	public void onProviderEnabled(String provider) {}
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {	}

	

}
