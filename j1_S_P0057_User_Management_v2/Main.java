/*
 * Copyright(C) 2021,  <FPT UNIVERSITY>.
 * J1.S.P0057
 * User management system. 
 * Record of change:
 * DATE			Version		AUTHOR		DESCRIPTION
 * 2021/10/15           v1		VINH		   Start                

 */
package j1_S_P0057_User_Management_v2;

public class Main {

    public static void main(String[] args) {
        ManageAccount manageAccount = new ManageAccount();
        String fileName = "user.dat";
        while (true) {
            // Display menu
            Display.displayMenu();
            int option = GetInput.getInt("> Choose: ", "The option must be a decimal number",
                    1, 3);

            switch (option) {
                case 1:
                    // Option 1: create new account
                    manageAccount.createNewAccount(fileName);
                    break;
                case 2:
                    // Option 2: Login System
                    manageAccount.loginSystem(fileName);
                    break;
                case 3:
                    // Option 3: Exit
                    System.exit(0);
                    break;
//			case 4:
//				manageAccount.showData(fileName);
//				break;
            }
        }

    }

}
