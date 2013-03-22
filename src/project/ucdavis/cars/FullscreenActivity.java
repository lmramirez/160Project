package project.ucdavis.cars;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.PushService;
import project.ucdavis.cars.util.SystemUiHider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;
import android.content.Intent;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//set up Parse stuff
		Parse.initialize(this, "RMuYyodUJs3arcuBbosfFACjxOfnVKXoniafSbyX", "r3FsUSaHpDwzmLal5yepjHJ4eaQTryFGsSTp2275"); 

		setContentView(R.layout.activity_fullscreen);
	}
	public void doLoginCheck(View view)	{
		
		//username and password should contain whatever was entered into the username and password fields
		String username = ((TextView) findViewById(R.id.loginUsernameField)).getText().toString();
		String password = ((TextView) findViewById(R.id.loginPasswordField)).getText().toString();
		
		//Validate user/password
		if(!username.equals("") && !password.equals("")){
			//attempt to log in user
			try {
				ParseUser.logIn(username, password);
				((TextView) findViewById(R.id.loginUsernameField)).setText("");
				((TextView) findViewById(R.id.loginPasswordField)).setText("");
				Intent i = new Intent(this, MainMenu.class);
				startActivityForResult(i,1);	
			} catch (ParseException e) {
				TextView error = (TextView) findViewById(R.id.error);
	 			error.setText("Could Not Log In, Please double-check your credentials.");
			}
							
		} else {
			TextView error = (TextView) findViewById(R.id.error);
			error.setText("Please ensure fields are completed.");
		}
	}
	
	public void goRegister(View view)	{
		Intent i = new Intent(this, Register.class);
		startActivityForResult(i,1);
	}
}
