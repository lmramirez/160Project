package project.ucdavis.cars;


import com.parse.ParseException;
import com.parse.ParseUser;

import project.ucdavis.cars.util.SystemUiHider;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class Register extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.register);
	}
	
	public void doRegister(View view)	{
		
		String username = ((TextView) findViewById(R.id.registerUsernameField)).getText().toString();
		String password = ((TextView) findViewById(R.id.registerPasswordField)).getText().toString();
		String dateOfBirth = ((TextView) findViewById(R.id.registerDobField)).getText().toString();
		String address = ((TextView) findViewById(R.id.registerAddressField)).getText().toString();
		String creditCard = ((TextView) findViewById(R.id.registerCcField)).getText().toString();
		String email = ((TextView) findViewById(R.id.registerEmailField)).getText().toString();
		String driversLicense = ((TextView) findViewById(R.id.registerDriverField)).getText().toString();
		String phone = ((TextView) findViewById(R.id.registerPhoneField)).getText().toString();
		
		if(!username.equals("") && !password.equals("")){
			//continue registration
			ParseUser user = new ParseUser();
			user.setUsername(username);
			user.setPassword(password);
			if(dateOfBirth!=null){
				user.put("dateOfBirth", dateOfBirth);
			}
			if(!address.equals("")){
				user.put("address", address);
			}
			if(!creditCard.equals("")){
				user.put("creditCard", creditCard);
			}
			if(!email.equals("")){
				user.put("email", email);
			}
			if(!driversLicense.equals("")){
				user.put("driversLicense", driversLicense);
			}
			if(!phone.equals("")){
				user.put("phone", phone);
			}
			
			user.put("isAdmin", false);
			
			try {
				user.signUp();
			} catch (ParseException e) {
				TextView error = (TextView) findViewById(R.id.error);
				error.setText("There was an error logging in, please check your internet connection.");
			}
			
		} else {
			//incomplete registration
			TextView error = (TextView) findViewById(R.id.error);
			error.setText("Please ensure you have filled in a username and password");
		}

		//Parse Fields via String <whatever> = ((TextView) findViewById(R.id.register<Fieldid>Field)).getText().toString();
		/*
		if (false )	{
			TextView error = (TextView) findViewById(R.id.error);
			error.setText("This is an error");
		}
		else	{
			//Actually Register the User
			finish(); // Close the view and go back to the login screen
		}
		*/
 	}
	public void goBack(View view)	{
		finish();
	}
}

