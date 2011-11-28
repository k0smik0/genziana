package net.iubris.genziana;

import roboguice.inject.InjectView;



import net.iubris.hermes.activity.HermesActivity;
import net.iubris.ulysses.finder.exception.PlacesFinderException;
import net.iubris.ulysses.model.PlaceList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GenzianaActivity extends HermesActivity<GenzianaService> {    
	
	@InjectView(R.id.here_button) private Button hereButton;
	@InjectView(R.id.list_button) private Button listButton;
	@InjectView(R.id.map_button) private Button mapButton;
		
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        hereButton.setOnClickListener(hereButtonListener);
		listButton.setOnClickListener(listButtonListener);
		mapButton.setOnClickListener(mapButtonListener);
	}
	
	private OnClickListener hereButtonListener = new OnClickListener() {	
		@Override
		public void onClick(View arg0) {
			getService().getLocation();			
		}
	};
	private OnClickListener listButtonListener = new OnClickListener() {	
		@Override
		public void onClick(View arg0) {
			try {
				PlaceList placeList = getService().getPlaces();
				
				
			} catch (PlacesFinderException e) {				
				e.printStackTrace();				
			}
		}
	};
	private OnClickListener mapButtonListener = new OnClickListener() {	
		@Override
		public void onClick(View arg0) {
		
		}
	};
}