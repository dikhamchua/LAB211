/*
 * Copyright(C) 2021,  <FPT UNIVERSITY>.
 * J1.S.P0052
 * Write a program to manage the geographic
 * Record of change:
 * DATE			Version		AUTHOR		DESCRIPTION
 * 2021/9/29     v1			VINH		                   

 */
package j1_S_P0052_Manage_Geographic;

public class Display {

    /**
     * Display the menu of program
     *
     * @param
     * @return
     */
    public static void displayMenu() {
        System.out.println("                 "
                + "              MENU              ");
        System.out.println("================================="
                + "=========================================");
        System.out.println("1. Input the information of "
                + "11 countries in East Asia");
        System.out.println("2. Display the information of "
                + "country you've just input\r\n"
                + "3. Search the information of country "
                + "by user-entered name\r\n"
                + "4. Display the information of countries "
                + "sorted name in ascending order  \r\n"
                + "5. Exit \r\n"
                + "");
        System.out.println("\n");
    }

}
