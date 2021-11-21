package j1_L_P0023_Fruit;

import java.util.ArrayList;
import java.util.List;

public class Validation {
	public static final String REGEX_YN = "^[yYNn]$";
	public static boolean isIdExist(List<Fruit> listFruits, String id) {
		for (Fruit fruit : listFruits) {
			if (fruit.getId().equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}

    public static boolean checkYesNo(String msg) {
        String choice = null;
        // loop until user input correct
        while (true) {
            System.out.println("Do you want to " + msg + "(Y/N)?");
            choice = GetInput.getString("your choice: ", "It must be a string", REGEX_YN);
            if (choice.equalsIgnoreCase("y")) {
                return true;
            }
            if (choice.equalsIgnoreCase("n")) {
                return false;
            }
            System.err.println("Invalid of choice, you must enter Y/y or N/n!");
        }
    }
    
    
    public static boolean checkFruitExistedByNamePriceOrigin(ArrayList<Fruit> 
            listFruitForBuyer, String name, double price, String origin) {
        for (Fruit fruit : listFruitForBuyer) {
            if (fruit.getName().equalsIgnoreCase(name) && fruit.getPrice() == price
                    && fruit.getOrigin().equalsIgnoreCase(origin)) {
                return true;
            }
        }
        return false;
    }
}
