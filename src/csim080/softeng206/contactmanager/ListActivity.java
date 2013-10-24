package csim080.softeng206.contactmanager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
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
		cd = ContactDatabase.getInstanceWithoutCreating();
		
		sortFirstButton = (Button)findViewById(R.id.sort_firstname);
		sortLastButton = (Button)findViewById(R.id.sort_lastname);
		toMenuButton = (Button)findViewById(R.id.return_menu);
		
		listView.setOnItemClickListener(new ListItemClickedListener());
		
		// Call the 'sort by first name' algorithm in the contact database,
		// then tell the list adapter that the data has changed, so the list
		// needs to be refreshed
		sortFirstButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				cd.sortFirst();
				cd.saveState();
				listView.invalidateViews();
			}
			
		});
		
		toMenuButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/* Old implementation, bad because it keeps activity on the stack.
				 * 
				Intent intent = new Intent();				
				intent.setClass(ListActivity.this, MainMenu.class);				
				startActivity(intent);	
				*/
				finish();
			}
		});
		
		setupListView();
		
	}
	
	// This function holds all the responsibility for setting up
	// the list viewer for the Contact list activity
	
	private void setupListView() {	
		cd = ContactDatabase.getInstanceWithoutCreating();
		ListAdapter listAdapter = new ContactListAdapter(ListActivity.this, cd.getContactList());
		listView.setAdapter(listAdapter);
	}
	
	private class ContactListAdapter extends ArrayAdapter {
		
		private Context context;
		private List<Contact> contactList;
		
		private ContactListAdapter(Context c, List<Contact> lis) {
			super(c, android.R.layout.simple_list_item_1, lis);
			this.context = c;
			this.contactList = lis;
		}
		
		public View getView(int position, View convertView, ViewGroup parent) {
			// The LayoutInflater will convert the xml code for the layout
			// into Java code, so initialize it and then use it to inflate xml
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View listItemView = inflater.inflate(R.layout.contact_list_item_layout, null);
			
			TextView first = (TextView) listItemView.findViewById(R.id.list_item_text_first_name);
			TextView last = (TextView) listItemView.findViewById(R.id.list_item_text_last_name);
			TextView mobile = (TextView) listItemView.findViewById(R.id.list_item_text_mobile_number);
			
			first.setText(contactList.get(position).getFirstName());
			last.setText(contactList.get(position).getLastName());
			mobile.setText(contactList.get(position).getMobile());
			
			// Set the background to alternate colours, for easier
			// readability (not used anymore, disables clickable)
			/*if (position % 3 == 1)
			
			if (position % 2 == 1) {
				listItemView.setBackgroundColor(Color.WHITE);
			} else {
				listItemView.setBackgroundColor(Color.rgb(200,200,200));
			}
			*/
			return listItemView;
			
		}
	}
	
	// Listener class for items in the list
	class ListItemClickedListener implements AdapterView.OnItemClickListener {
		
		@Override
		public void onItemClick(AdapterView<?> parentView, View clickedView, int clickedViewPosition, long id) {
			
			// String displayText = "You clicked item" + Integer.toString(clickedViewPosition);
			//Toast.makeText(clickedView.getContext(), displayText, Toast.LENGTH_LONG).show(); // DEBUG LINE
			
			// Initialize a singleton contact holder
			ContactSingleton.createInstance(cd.getContactList().get(clickedViewPosition));
			
			Intent intent = new Intent();
			intent.setClass(ListActivity.this, ContactDetail.class);
			
			// Update the input holder object and pass it on
			startActivity(intent);
		}
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
	
	protected void onResume() {;
		super.onResume();
		// Re-synchronize the file system with the object in memory
		// (i.e. destroy and reinitialize the ContactDatabase)
		listView.invalidateViews();
		//Toast.makeText(listView.getContext(), "test", Toast.LENGTH_LONG).show(); // DEBUG LINE
	}

}
