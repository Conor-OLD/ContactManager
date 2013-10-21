package csim080.softeng206.contactmanager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class ListActivity extends Activity {
	
	// Setup a tag constant to be used in logging
	private static final String TAG = "ContactList";
	
	private ListView listView;
	private Button sortFirstButton;
	private Button sortLastButton;
	private Button toMenuButton;
	// Class has its own ContactDatabase
	private ContactDatabase cd;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		// Show the Up button in the action bar.
		setupActionBar();
		
		listView = (ListView)findViewById(R.id.list_view);
		// Set up the Contact Database using the listView's context.
		// The contactDatabase constructor is called with this context, from which
		// the newly-instantiated ContactDatabase object uses the context to find
		// the appropriate file directory in the Android device's internal storage
		// that it then uses to populate its own 'ContactList' List object, which
		// contains 'Contact' objects
		cd = new ContactDatabase(listView.getContext());
		
		sortFirstButton = (Button)findViewById(R.id.sort_firstname);
		sortLastButton = (Button)findViewById(R.id.sort_lastname);
		toMenuButton = (Button)findViewById(R.id.return_menu);
		
		toMenuButton.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();				
				intent.setClass(ListActivity.this, MainMenu.class);				
				startActivity(intent);	
			}
		});
		
		setupListView();
		
	}
	
	// This function holds all the responsibility for setting up
	// the list viewer for the Contact list activity
	
	private void setupListView() {
		//this.cd = 
		// Real implementation will draw on the 'Contact' class
		List<String> displayList = new ArrayList<String>();
		displayList.add("John Smith");
		displayList.add("Mary Smith");
		displayList.add("Doug McDonald");
		displayList.add("Mark Andrews");
		displayList.add("Nicola Andrews");
		displayList.add("Jakob Henry");
		
		ListAdapter listAdapter = new ArrayAdapter<String>(
				ListActivity.this, android.R.layout.simple_list_item_1, displayList);
		listView.setAdapter(listAdapter);
		
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
		getMenuInflater().inflate(R.menu.list, menu);
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
