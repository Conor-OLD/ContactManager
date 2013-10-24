package csim080.softeng206.contactmanager;

public class Capitalize {

	// This class is responsible for capitalizing a string (a name, for 
	// example)
	
    public static String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

   

}