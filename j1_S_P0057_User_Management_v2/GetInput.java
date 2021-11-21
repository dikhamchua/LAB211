package j1_S_P0057_User_Management_v2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GetInput {

    /**
     * User enter the option
     *
     * @param
     * @return option
     */
    static Scanner scanner = new Scanner(System.in);

    public static int getInt(String msgString, String errorString,
            int min, int max) {
        Scanner scanner = new Scanner(System.in);

        // ask user until true input
        while (true) {
            System.out.print(msgString);
            try {
                String input = scanner.nextLine().trim();
                //if input is empty or have only space => tell user
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    int number = Integer.parseInt(input);
                    // check the range of input
                    if (min <= number && number <= max) {
                        return number;
                    } else {
                        System.out.println("Invalid. The input must be "
                                + "in range " + min + " to " + max);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println(errorString);
            }
        }

    }

    /**
     * Get a String input
     *
     * @param msgString : display message
     * @param error : display error
     * @param regexString : match the string true
     * @return string
     */
    protected static String getString(String msgString, String error, String regexString) {
        boolean check = false;
        // ask user until true input
        while (true) {
            System.out.println(msgString);
            String string = scanner.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Input can't be empty!!!");
            } // Check the value of user enter is match with the regex?
            // if true then return the string  
              else if (string.matches(regexString)) {
                check = true;
                return string;
            } else {
                System.out.println(error);
            }
        }

    }

    /**
     * Get a float number
     *
     * @param msgString : display message
     * @param error : display error
     * @return an float number
     */
    protected static float getfloat(String msgString, String error, float min, float max) {

        // ask user until true input
        while (true) {
            System.out.println(msgString);
            try {
                String input = scanner.nextLine().trim();
                //if input is empty or have only space => tell user
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    float floatInput = Float.parseFloat(input);
                    // check the range of input
                    if (min <= floatInput && floatInput <= max) {
                        return floatInput;
                    } else {
                        System.out.println("Invalid. The input must be in range "
                                + min + " to " + max);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }
    
    

    public static String getDate(String msg, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        String date;
        while (true) {
            System.out.println(msg);
            date = scanner.nextLine().trim();
            if (date.isEmpty()) 
                System.out.println("Input can't be empty");
             else if (!date.matches(regex)) 
                System.out.println(error);
             else if (isValidDate(date)) 
                return date;
             else 
                System.out.println("The date does not exist !!!");
            
        }

    }

    public static boolean isValidDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = null;
        dateFormat.setLenient(false);

        try {
            dateTest = dateFormat.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    
    
}
