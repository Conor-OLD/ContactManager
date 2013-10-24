package csim080.softeng206.contactmanager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.widget.Toast;

public class SettingsManager {
	

	// Private constructor for static method class only
	private SettingsManager() {
		
	}
	
	public static int loadSettings(Context context) {
		
		int capital = 0;
			
		// Read the contents of the internal memory to the list of strings
		try {
			FileInputStream fin = context.openFileInput("settingsFile.db");
			InputStreamReader in = new InputStreamReader(fin);
			BufferedReader br = new BufferedReader(in);
			
			String line = null;
			//String sep = System.getProperty("line.separator");
			StringBuffer sb = new StringBuffer();
			
			// Read initial line (totalContacts value)
			line = br.readLine();			
			try {
				capital = Integer.parseInt(line);
			} catch (NumberFormatException e) {
				capital = 0;
			}
		} catch (Exception e) {
			//System.out.println("File does not exist, creating file."); // DEBUG line
			//Toast.makeText(context, "File does not exist, creating file", Toast.LENGTH_LONG).show();
			
			// Create an empty settings file to start from
			try {
				FileOutputStream outputStream;
				outputStream = context.openFileOutput("settingsFile.db", Context.MODE_PRIVATE);
				outputStream.write("0".getBytes());
				outputStream.flush();
				outputStream.close();
				//System.out.println("Write success"); // DEBUG line
				//Toast.makeText(context, "Successfully created empty settings file.", Toast.LENGTH_LONG).show(); // DEBUG line
			} catch (FileNotFoundException e2) {
				System.out.println("Cannot create empty settings file."); // DEBUG line
			} catch (Exception e2) {
				e.printStackTrace();
			}
			
			
		}
		
		return capital;
	}
	
	public static void saveSettings(Context context, int capital) {
		// Save settings every time a change occurs, into data.
		
		FileOutputStream outputStream;
		try {
			outputStream = context.openFileOutput("settingsFile.db", Context.MODE_PRIVATE);
			// Write a 0 for no capitalization, or a 1 for capitalization
			if (capital == 1) {			
				outputStream.write("1".getBytes());
			} else {
				outputStream.write("0".getBytes());
			}
			outputStream.flush();
			outputStream.close();
			
		} catch (Exception e) {
			SettingsManager.loadSettings(context);
		}

		
	}
	
	

}
