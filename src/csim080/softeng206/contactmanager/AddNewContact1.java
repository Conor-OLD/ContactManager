package csim080.softeng206.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class AddNewContact1 extends Activity {
	
	// Setup a tag constant to be used in logging
	private static final String TAG = "AddContactName";
	
	// Declare an 'InputHolder' object variable; this will be used to save
	// contact data while an 'AddContact' procedure is underway
	private InputHolder inputHolder;
	
	private Button backButton;
	private Button nextButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_contact1);
		
		// Instantiate an inputHolder object (this will be the same object
		// that is used in the following activities for Add Contact to
		// temporarily store input information
		inputHolder = new InputHolder();
		
		// Show the Up button in the action bar.
		setupActionBar();
		
		
		backButton = (Button)findViewById(R.id.button_back_add1);				
		// Set up the listener for the button (anonymous class for simplicity)
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Finish the add names activity, returning to main menu
				finish();				
			}
		});
		
		nextButton = (Button)findViewById(R.id.button_next_add1);				
		
		// Set up the listener for the button (anonymous class for simplicity)
		nextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Get the string contents from the input fields so that
				// they can be updated to the 'InputHolder' object
				
				
				Intent intent = new Intent();
				intent.setClass(AddNewContact1.this, AddNewContact2.class);
				// Finish this activity, the Android back button should just return
				// to main menu if pressed at any point during the add contacts stage
				startActivity(intent);				
			}
		});
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_new_contact1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
