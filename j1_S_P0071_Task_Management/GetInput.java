package j1_S_P0071_Task_Management;

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
            System.out.print(msgString);
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
    protected static double getDouble(String msgString, String error, double d, double f) {

        // ask user until true input
        while (true) {
            System.out.print(msgString);
            try {
                String input = scanner.nextLine().trim();
                //if input is empty or have only space => tell user
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    double floatInput = Double.parseDouble(input);
                    //if floatInput not divide to 0.5 then tell user
                    if (floatInput % 0.5 != 0) {
                        System.out.println("It must be divide to 0.5");
                    } // check the range of input
                    else if (d <= floatInput && floatInput <= f) {
                        return floatInput;
                    } else {
                        System.out.println("Invalid. The input must be in range "
                                + d + " to " + f);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }

    public static String getDate(String msg, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        Date dateTime = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = dateFormat.format(dateTime);
        String date;
        while (true) {
            System.out.print(msg);
            date = scanner.nextLine().trim();
            boolean dateLessThanCurrentDate = checkDate_1LessThanDate_2(date, currentDate);
            if (date.isEmpty()) {
                System.out.println("Input can't be empty");
            } else if (!date.matches(regex)) {
                System.out.println(error);
            } else if (isValidDate(date) == false) {
                System.out.println("The date does not exist !!!");
            } else if (dateLessThanCurrentDate == true) {
                 System.err.println("Invalid of date, date must be equal or greater"
                        + " current date " + currentDate + "!");
            }else {
                return date;
            }
                
            }
        }

    

    public static boolean isValidDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateTest = null;
        dateFormat.setLenient(false);

        try {
            dateTest = dateFormat.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public static boolean checkDate_1LessThanDate_2(String date_1, String date_2) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date firstDate;
        Date secondDate;
        try {
            firstDate = dateFormat.parse(date_1);
            secondDate = dateFormat.parse(date_2);
            if (firstDate.compareTo(secondDate) < 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
