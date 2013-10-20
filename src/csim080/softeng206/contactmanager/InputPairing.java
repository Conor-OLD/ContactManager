package csim080.softeng206.contactmanager;

import android.app.Activity;

public class InputPairing {
	// Stub class used exclusively by InputHolder that simply
	// contains a reference to a class and an input that is being
	// held (by an InputPairing object that is inside an InputHolder)
	
	private Activity activity;
	private Object value;
	
	// Will use a better implementation than just holding an 'Object'
	// here, probably. Most likely an enum will be used that can cover
	// all of the ~10 inputs that will finally be used so it can more
	// effectively deal with their respective types than having to deal
	// with an 'Object' (i.e. deciding what type to cast it to)

}
