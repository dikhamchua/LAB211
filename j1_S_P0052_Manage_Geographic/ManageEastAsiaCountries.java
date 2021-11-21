/*
 * Copyright(C) 2021,  <FPT UNIVERSITY>.
 * J1.S.P0052
 * Write a program to manage the geographic
 * Record of change:
 * DATE			Version		AUTHOR		DESCRIPTION
 * 2021/5/10      v1.4      Vinh        Check condition in option 1 and 3
 * 2021/4/10	` v1.3		Vinh		Check listEmpty in case 3
 * 2021/10/1	  v1.2		Vinh		Change name of method codeExist and nameExist
 * 2021/09/30     v1.1		Vinh		Check condition about 11 countries
 * 2021/09/29     v1		Vinh		Initialization               

 */
package j1_S_P0052_Manage_Geographic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManageEastAsiaCountries {

    /**
     * Add information of a country into list
     *
     * @param listCountries
     * @return
     */
    public static void addCountryInformation(ArrayList<EastAsiaCountries> listCountries) {

        // if list full then tell user and return
        if (listCountries.size() == 11) {
            System.out.println("\nAlready have 11 countries in list!!!");
            return;
        }

        // Loop until listcountries's size is 11
        String countryCode;
        // loop until true
        while (true) {
            // regex: String must be start and end with character from A-Z
        	// or a-z 
            countryCode = GetInput.getString("Enter code of country: ",
                    "The code must be a string. Enter again!!",
                    "^[a-zA-Z ]+$");
            countryCode = countryCode.toUpperCase();

            // if countryCode is exist -> enter again,
            // else break and enter other information
            if (checkCodeExist(countryCode, listCountries)) {
                System.out.println("Duplicate code, enter again !!!");
            } else {
                break;
            }
        }

        // regex: String must be start and end with character from A-Z
    	// or a-z. (can have space)
        String name = GetInput.getString("Enter name of country: ",
                "Name country must be a string. Enter again!!!",
                "^[a-zA-Z ]+$");
        name = ConverToTitleCase(name);

        float totalArea = GetInput.getfloat("Enter total Area: ",
                "The total area must be a decimal positive number. Enter again!!!",
                0, Float.MAX_VALUE);

        // regex: String must be start and end with character from A-Z
    	// or a-z (can have space)
        String terrain = GetInput.getString("Enter terrain of country: ",
                "The terrain must be a string. Enter again!!",
                "^[a-zA-Z ]+$");
        terrain = ConverToTitleCase(terrain);

        listCountries.add(new EastAsiaCountries(countryCode, name, totalArea, terrain));
        System.out.println("\nAdd successfully");

    }
    
    //convert name to titleCase 
    private static String ConverToTitleCase(String name) {
		
    	String[] names = name.split("\\s"); //regex:  space
    	name = "";
    	//loop to access all elements in array names
    	for (String string : names) {
			string = string.substring(0,1).toUpperCase() +
					string.substring(1).toLowerCase()+" ";
			name = name + string;
		}
    	
		return name.trim();
	}

	/**
     * Check is CountryCode exist?
     *
     * @param code
     * @param listCountries
     *
     * @return true or false
     */
    private static boolean checkCodeExist(String code, ArrayList<EastAsiaCountries> listCountries) {
        // loop to access each country in list
        for (EastAsiaCountries eastAsiaCountries : listCountries) {
            // if country's code == code -> return true
            if (eastAsiaCountries.countryCode.equals(code)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Display information of countries just input
     *
     * @param listCountries
     *
     * @param
     * @return
     */
    public static void getRecentlyEnteredInformation(ArrayList<EastAsiaCountries> listCountries) {
        // if listCountries not empty then get information,
        // else tell user list empty
        if (!listCountries.isEmpty()) {
            System.out.println("==================================="
                    + "=======================================\r\n");
            System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
            listCountries.get(listCountries.size()-1).display();
            System.out.println("\n\n");
        } else {
            System.out.println("List country is empty. Nothing to display!!!\n\n");
        }
    }

    /**
     * Search information of country by name
     *
     * @param listCountries
     *
     * @param
     * @return
     */
    public static void searchInformationByName(ArrayList<EastAsiaCountries> listCountries) {
        // if list not empty => search
        //else tell user list is empty
        if (!listCountries.isEmpty()) {
        	// regex: String must be start and end with character from A-Z
        	// or a-z (can have space)
            String name = GetInput.getString("Enter the name you want to search for: ",
                    "Name country must be a string!!! ", "^[a-zA-Z ]+$");
            boolean flag = false;
            // Loop to access each listCountry's elements
            for (EastAsiaCountries eastAsiaCountries : listCountries) {

                // if country's name contain name user enter then display information
                if (eastAsiaCountries.getCountryName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(
                            "==================================="
                            + "=======================================\r\n");
                    System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name",
                            "Total Area", "Terrain");
                    eastAsiaCountries.display();
                    flag = true;
                    System.out.println("\n\n");
                }

            }

            // if country not exist on list then tell user
            if (flag == false) {
                System.out.println("The country doesn't seem to be in list");
            }

        } else {
            System.out.println("List is empty!!! Nothing to search");
        }

        System.out.println("\n\n");

    }

    /**
     * display information of countries in ascending order
     *
     * @param listCountries
     * @param
     * @return
     */
    public static void sortInformationByAscendingOrder(ArrayList<EastAsiaCountries> listCountries) {
        // if listCountries not empty then sort by ascending order,
        // else tell user nothing to sort
        if (!listCountries.isEmpty()) {
            Collections.sort(listCountries, new Comparator<EastAsiaCountries>() {

                @Override
                public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                    return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
                }
            });
            System.out.println("==================================="
                    + "=======================================\r\n");
            System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
            // Loop to access each listCountry's elements
            for (EastAsiaCountries eastAsiaCountries : listCountries) {
                eastAsiaCountries.display();
            }

        } else {
            System.out.println("List is empty!!! Nothing to sort\n\n");
        }

    }

}
