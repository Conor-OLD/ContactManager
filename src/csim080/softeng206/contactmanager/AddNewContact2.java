package csim080.softeng206.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class AddNewContact2 extends Activity {
	
	// Setup a tag constant to be used in logging
	private static final String TAG = "AddContactNumbers";
	
	Button backButton;
	Button nextButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_contact2);
		
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
