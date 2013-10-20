package csim080.softeng206.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainMenu extends Activity {

	// Create a button object
	private Button buttonViewContacts;
	private Button buttonAddContact;
	private Button buttonSettingsMenu;
	private Button buttonHelpMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		
		// Instantiate the contact list button and create a reference to the button in
		// the layout (and cast to Button type)
		buttonViewContacts = (Button)findViewById(R.id.ButtonContList);
		
		// Set up the listener for the button (anonymous class for simplicity)
		buttonViewContacts.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

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

		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
