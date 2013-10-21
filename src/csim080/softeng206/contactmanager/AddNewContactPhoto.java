package csim080.softeng206.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class AddNewContactPhoto extends Activity {
	
	// Setup a tag constant to be used in logging
	private static final String TAG = "AddContactPhoto";
	
	// Declare an 'InputHolder' object variable; this will be used to save
	// contact data while an 'AddContact' procedure is underway
	private InputHolder inputHolder;
	
	Button yesButton;
	Button noButton;
	Button backButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_contact_photo);
		
		//yesButton = (Button)findViewFromId
		
		noButton = (Button)findViewById(R.id.button_photo_no);
		noButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent intent = new Intent(getApplicationContext(), MainMenu.class);
				
				// Setting this flag upon a successful series of AddContact activities
				// will ensure that all activities (i.e., the ones that were opened during the 
				// addContact stage) will be removed from the stack
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("EXIT", true);
				startActivity(intent);
				
				
			}
		});
		
		backButton = (Button)findViewById(R.id.button_photo_back);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Finish the add photo activity so that it isn't added to the stack
				finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_new_contact_photo, menu);
		return true;
	}

}
