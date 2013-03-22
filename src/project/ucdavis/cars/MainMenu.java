package project.ucdavis.cars;

import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_menu);
	}
	public void doViewRides(View view)	{
		//Change activity to show rides
		if (false /*Check if num rides > 0*/)	{
			TextView error = (TextView) findViewById(R.id.error);
			error.setText("");
			Intent i = new Intent(this, ViewRides.class);
			startActivityForResult(i,1);
		}
		else	{
			TextView error = (TextView) findViewById(R.id.error);
			error.setText("This is an error"/*Change to relevant error text*/);
		}
	}
	public void doNewRide(View view)	{
		//Change activity to new rides
		TextView error = (TextView) findViewById(R.id.error);
		error.setText("");
		Intent i = new Intent(this, NewRide.class);
		startActivityForResult(i,1);
	}
	
	public void	doLogout(View view)	{
		ParseUser.logOut();
		finish();
	}
}
