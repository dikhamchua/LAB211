package j1_S_P0057_User_Management_v2;

import java.io.File;
import java.util.ArrayList;

public class ManageAccount {

    FileProcess fileProcess = new FileProcess();

    /* This function use to create a new account 
	 * 
	 * parameter: String fileName - which account stored
	 * **/
    public void createNewAccount(String fileName) {
        // check file exist
        if (checkExistedFile(fileName) == false) {
            System.out.println("File is not existed!!");
        }
        ArrayList<Account> list = new ArrayList<>();
        list.addAll(fileProcess.readData(fileName));
        String username;
        while (true) {
            // REGEX: any character except space and has at least 5 character
            username = GetInput.getString("Enter Username: ", "You must enter "
                    + "least at 5 character, and no space!",
                    "[^ ]{5,}");
            // if username exist in database then tell user else break
            if (checkExistUsername(list, username, fileName)) {
                System.out.println("Username has existed in file. Please enter "
                        + "other username !!!");
            } else {
                break;
            }
        }
        // REGEX: any character except space and has at least 6 character
        String password = GetInput.getString("Enter Password: ", "You must enter "
                + "least at 6 character, and no space!",
                "[^ ]{6,}");
        list.add(new Account(username, password));
        fileProcess.writeData(list, fileName);
        System.out.println("Create account successfull !!");

    }

    /*
	 * This function use to check username exist in database
	 * 
	 * parameter: ArrayList<Account> list - list stored information of objects
	 * parameter : String username - username which is user enter
	 * paramter : String fileName - which account store
	 * **/
    private boolean checkExistUsername(ArrayList<Account> list, String username, String fileName) {
        list = fileProcess.readData(fileName);
        for (Account account : list) {
            if (account.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /*
	 * This function use to check file exist 
	 * 
	 * parameter : String fileName - file name
	 * **/
    public boolean checkExistedFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            return true;
        }
        return false;
    }

    /*
	 * This function use to login 
	 * 
	 * parameter : String fileName - which account store
	 * **/
    public void loginSystem(String fileName) {
        ArrayList<Account> list = new ArrayList<>();
        list.addAll(fileProcess.readData(fileName));
        String username = GetInput.getString("Enter Username: ", "You must enter"
                + " least at 5 character, and no space!",
                "[^ ]{5,}");
        String password = GetInput.getString("Enter Password: ", "You must enter"
                + " least at 6 character, and no space!",
                "[^ ]{6,}");
        for (Account account : list) {
            if (account.getUserName().equals(username)
                    && account.getPassWord().equals(password)) {
                System.out.println("Login successful!");
                return;
            }
        }
        System.out.println("Login fail!!");
        System.out.println("Username or password is not correct!!\n");
    }
//
//	public void showData(String fileName) {
//		ArrayList<Account> list = new ArrayList<>();
//		list.addAll(fileProcess.readData(fileName));
//		for (Account account : list) {
//			System.out.println(account.getUserName() +"\t" +account.getPassWord());
//		}
//	}

}
