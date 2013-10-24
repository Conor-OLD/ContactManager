package csim080.softeng206.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainMenu extends Activity {
	
	// Setup a tag constant to be used in logging
	private static final String TAG = "MainMenu";

	// Create a button object
	private Button buttonViewContacts;
	private Button buttonAddContact;
	private Button buttonSettingsMenu;
	private Button buttonAbout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		ContactDatabase.getInstance(getApplicationContext());
		
		// Instantiate the contact list button and create a reference to the button in
		// the layout (and cast to Button type)
		buttonViewContacts = (Button)findViewById(R.id.ButtonContList);
		
		// Set up the listener for the button (anonymous class for simplicity)
		buttonViewContacts.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Log.d(TAG, "buttonViewContacts clicked");

				// Decide the action to be performed upon click (i.e. start
				// the appropriate activity by setting the class of the new 
				// Intent object as the ContactListActivity class
				Intent intent = new Intent();
				intent.setClass(MainMenu.this, ListActivity.class);
				
				startActivity(intent);
				
			}
		});
		
		// Instantiate the add contact button
		buttonAddContact = (Button)findViewById(R.id.ButtonAddNew);
		
		// Set up the listener for the button (anonymous class for simplicity)
		buttonAddContact.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				// Decide the action to be performed upon click (i.e. start
				// the appropriate activity by setting the class of the new 
				// Intent object as the ContactListActivity class
				Intent intent = new Intent();
				intent.setClass(MainMenu.this, AddNewContact1.class);
				
				startActivity(intent);
				
			}
		});
		
		// Instantiate the settings button
		buttonSettingsMenu = (Button)findViewById(R.id.ButtonSettings);
		
		// Set up the listener for the button (anonymous class for simplicity)
		buttonSettingsMenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				// Decide the action to be performed upon click (i.e. start
				// the appropriate activity by setting the class of the new 
				// Intent object as the ContactListActivity class
				Intent intent = new Intent();
				intent.setClass(MainMenu.this, SettingsActivity.class);
				
				startActivity(intent);
				
			}
		});
		
		
		
		// Instantiate the 'about' button
		buttonAbout = (Button)findViewById(R.id.ButtonHelp);
		
		// Set up the listener for the button (anonymous class for simplicity)
		buttonAbout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				// Decide the action to be performed upon click (i.e. start
				// the appropriate activity by setting the class of the new 
				// Intent object as the ContactListActivity class
				Intent intent = new Intent();
				intent.setClass(MainMenu.this, AboutActivity.class);
				
				startActivity(intent);
				
			}
		});

		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	
	// This needs to be called so that the file system is also updated when
	// the list manager returns to the menu
	protected void onResume() {
		super.onResume();
		// Re-synchronize the file system with the object in memory
		// (i.e. destroy the ContactDatabase)
		ContactDatabase.destroyInstance();
		ContactDatabase.getInstance(getApplicationContext());
		//Toast.makeText(listView.getContext(), "test", Toast.LENGTH_LONG).show(); // DEBUG LINE
	}

}
