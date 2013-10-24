package csim080.softeng206.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.NavUtils;



public class SettingsActivity extends Activity {
	
	private Button toMenuButton;
	private Button capitalButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		// Show the Up button in the action bar.
		setupActionBar();
		
		toMenuButton = (Button)findViewById(R.id.SettingsToMenu);
		toMenuButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		
		capitalButton = (Button)findViewById(R.id.SettingsCapital);
		capitalButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				int temp = SettingsManager.loadSettings(getApplicationContext());
				
				if (temp == 0) {
					SettingsManager.saveSettings(getApplicationContext(), 1);
					Toast.makeText(v.getContext(), "Auto-capitalization turned on.", Toast.LENGTH_LONG).show();
					
				} else {
					SettingsManager.saveSettings(getApplicationContext(), 0);
					Toast.makeText(v.getContext(), "Auto-capitalization turned off.", Toast.LENGTH_LONG).show();
				}
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
		getMenuInflater().inflate(R.menu.settings, menu);
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

