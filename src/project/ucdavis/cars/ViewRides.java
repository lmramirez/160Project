package project.ucdavis.cars;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewRides extends Activity {
	int currentIndex;
	int maxIndex;
	//TODO Create variable that contains results of getRides query
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_rides);
		//Do query, get all rides for this user -- or if user is admin, get all rides
		this.currentIndex = 0;
		//this.maxIndex = however many rides there are to display
	}
	//The next two methods are sorta vapourous right now
	//Essentially, my idea is to get the rides in a maxtrix such that the rows each represent a single ride, and the 
	//columns each represent the relevant field in the database id (RideId,CarId,etc)
	//Then you just do setText on the relevant fields based on the current row and column of the ride matrix
	
	//I plan on including the following fields:
	//Requesting Username (union the userid with users)
	//Requested Car (union with cars);
	//Start Time
	//End time
	//Start Station name (union with station)
	//End Station name (union with station)
	//Passenger list
	//The fields can be accessed by R.id.view<descriptor>Field
	public void doNext(View view)	{
		this.currentIndex = (this.currentIndex + 1) % this.maxIndex;
		//For example, 
		//(TextView) findViewById(R.id.viewStartTimeField).setText(getRideResults[currentIndex][3]); 
		//would set the start time
	}
	
	public void doPrev(View view)	{
		 this.currentIndex -= 1;
		 if (this.currentIndex == -1)	{
			 this.currentIndex = maxIndex-1;
		 }
		 
	}
	//this is all this method needs
	public void goBack(View view)	{
		finish();
	}
}
