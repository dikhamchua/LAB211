/*
 * Copyright(C) 2021,  <FPT UNIVERSITY>.
 * J1.S.P0052
 * Write a program to manage the geographic
 * Record of change:
 * DATE			Version		AUTHOR		DESCRIPTION
 * 2021/9/29     v1			VINH		                   

 */
package j1_S_P0052_Manage_Geographic;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<EastAsiaCountries> listCountries = new ArrayList<EastAsiaCountries>();
        listCountries.add(new EastAsiaCountries("CN", "China",
                9640011, "Nice"));
       listCountries.add(new EastAsiaCountries("HK", "Hong Kong",
                1104, "Small"));
       listCountries.add(new EastAsiaCountries("MO", "Macau",
                30, "Nice"));
       listCountries.add(new EastAsiaCountries("JP", "Japan",
                377930, "Nice"));
       listCountries.add(new EastAsiaCountries("MN", "Mongolia",
                1564100, "Nice"));
       listCountries.add(new EastAsiaCountries("KP", "North Korea",
                120538, "Nice"));
       listCountries.add(new EastAsiaCountries("KR", "Korea",
                100210, "Small"));
       listCountries.add(new EastAsiaCountries("TW", "Taiwan",
                36197, "Small"));
       listCountries.add(new EastAsiaCountries("LA", "Laos",
                237955, "Small"));
       


        // loop until true
        while (true) {
            // display menu
            Display.displayMenu();
            // select option
            int option = GetInput.selectOption();
            // user choose the option
            switch (option) {
                case 1:
                    // option 1: input the information countries
                    ManageEastAsiaCountries.addCountryInformation(listCountries);
                    break;
                case 2:
                    // option 2: display information of countries just input
                    ManageEastAsiaCountries.getRecentlyEnteredInformation(listCountries);
                    break;
                case 3:
                    // option 3: search information of country by name
                    ManageEastAsiaCountries.searchInformationByName(listCountries);
                    break;

                case 4:
                    // option 4: display information of countries in ascending order
                    ManageEastAsiaCountries.sortInformationByAscendingOrder(listCountries);
                    break;
                case 5:
                    // option 5: exit the program
                    System.exit(0);
            }

        }

    }
}
