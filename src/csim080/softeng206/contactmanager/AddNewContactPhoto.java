package csim080.softeng206.contactmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class AddNewContactPhoto extends Activity {
	
	Button yesButton;
	Button noButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_contact_photo);
		
		//yesButton = (Button)findViewFromId
		
		noButton = (Button)findViewById(R.id.button_photo_no);
		noButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent intent = new Intent();
				intent.setClass(AddNewContactPhoto.this, MainMenu.class);
				
				startActivity(intent);	
				
				
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
