package csim080.softeng206.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewContact2 extends Activity {
	
	// Setup a tag constant to be used in logging
	private static final String TAG = "AddContactNumbers";
	
	// Declare an 'InputHolder' object variable; this will be used to save
	// contact data while an 'AddContact' procedure is underway
	private InputHolder inputHolder;
	
	Button backButton;
	Button nextButton;
	private EditText txtBoxMobile = null;
	private EditText txtBoxHome = null;
	private EditText txtBoxWork = null;
	private EditText txtBoxHomeAd = null;
	private EditText txtBoxEmail = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_contact2);
		
		// Get the running instance of the singleton 'InputHolder'
		inputHolder = InputHolder.getInstance();
		
		backButton = (Button)findViewById(R.id.button_back_add2);				
		
		// Set up the listener for the button (anonymous class for simplicity)
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Finish the add phone numbers activity, which will return to previous screen
				finish();				
			}
		});
		
		nextButton = (Button)findViewById(R.id.button_next_add2);				
		
		// Set up the listener for the button (anonymous class for simplicity)
		nextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Get the string contents from the input fields so that
				// they can be updated to the 'InputHolder' object
				txtBoxMobile = (EditText) findViewById(R.id.mobile_phone);
				txtBoxHome = (EditText) findViewById(R.id.home_phone);
				txtBoxWork = (EditText) findViewById(R.id.work_phone);
				txtBoxHomeAd = (EditText) findViewById(R.id.home_address);
				txtBoxEmail = (EditText) findViewById(R.id.email_address);
				
				String mobile = txtBoxMobile.getText().toString();
				String home = txtBoxHome.getText().toString();
				String work = txtBoxWork.getText().toString();
				String email = txtBoxHomeAd.getText().toString();
				String homeAd = txtBoxEmail.getText().toString();
				
				inputHolder.setNumbers(mobile, home, work, email, homeAd);
				
				Toast.makeText(v.getContext(), "First name: " + inputHolder.firstNameCall(), Toast.LENGTH_LONG).show(); // DEBUG line
				
				Intent intent = new Intent();
				intent.setClass(AddNewContact2.this, AddNewContactPhoto.class);
				
				startActivity(intent);				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_new_contact2, menu);
		return true;
	}

}
