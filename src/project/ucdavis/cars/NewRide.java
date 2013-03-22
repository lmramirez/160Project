package project.ucdavis.cars;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class NewRide extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_ride);
		
		Spinner startStation = (Spinner) findViewById(R.id.newStartStationSpinner);
		Spinner endStation = (Spinner) findViewById(R.id.newEndStationSpinner);
		Spinner car = (Spinner) findViewById(R.id.newCarSpinner);
		//The following 9 lines initializes the dropdowns.
		//For these ArrayAdapters, create ArrayList<String> for each where each entry is the 
		//friendly name of the car station etc. to replace the null value
		//Keep them in the correct order id wise so index 0 == id 0 (or whatever)
		//Save the ArrayLists because we'll use them in doNewRide to get the ids. That or you can do another db query.
		//Either way.
		/*
		ArrayAdapter<String> adapterStart = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,null);
		ArrayAdapter<String> adapterEnd = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,null);
		ArrayAdapter<String> adapterCar = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,null);
		car.setAdapter(adapterCar);
		endStation.setAdapter(adapterEnd);
		startStation.setAdapter(adapterStart);
		*/
		car.setSelection(0);
		endStation.setSelection(0);
		startStation.setSelection(0);
	}
	public void doNewRide(View view)	{
		//get + validate ride information
		//you can get the dropdown choices by
		//Spinner startStation = (Spinner) findViewById(R.id.newStartStationSpinner);
		//String whatever = startStation.getSelectedItem().toString();
		//Otherwise, you can use the same methods from register et al to get the field values
		//The format for the ids is R.id.new<Descriptor><Type> where type is Spinner, Field, or Checkbox
		if (false /*check error condition for ride creation*/)	{
			TextView error = (TextView) findViewById(R.id.error);
			error.setText("This is an error"/*Change to relevant error text*/);
		}
		else	{
			//Actually add the ride to the database
			finish(); // Close the view and go back to the main menu
		}
	}
	public void goBack(View view)	{
		finish();
	}
}
