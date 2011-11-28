package net.iubris.genziana;

import android.location.Location;
import com.google.inject.Inject;

import net.iubris.hermes.service.HermesService;
import net.iubris.ulysses.finder.PlaceFinder;
import net.iubris.ulysses.finder.exception.PlacesFinderException;
import net.iubris.ulysses.model.PlaceList;

public class GenzianaService extends HermesService<GenzianaService> {
	
	@Inject private Locator locator;
	
	@Inject private PlaceFinder placeFinder;
	
	private Location location;	
	
	public Location getLocation() {
		//if (location != null) {
			location = locator.getLocation();
		//}
		return location;
	}
	
	public PlaceList getPlaces() throws PlacesFinderException {		
		return placeFinder.findPlaces(location);
	}
	
	

}
