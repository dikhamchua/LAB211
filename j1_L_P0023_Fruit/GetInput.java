package j1_L_P0023_Fruit;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
                    
                    // check the range of input
                    if (d <= floatInput && floatInput <= f) {
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
    
    public static int getQuantityFruitOrder(Fruit fruitOrder) {
        while (true) {
            // get quantity
            System.out.print("Please input quantity: ");
            String temp = scanner.nextLine().trim();
            int quantityOrder = 0;
            if (temp.isEmpty()) {
                System.err.println("Invalid of quantity, quantity must not empty!");
                continue;
            }
            try {
                quantityOrder = Integer.parseInt(temp);
                if (quantityOrder < 0) {
                    System.err.println("Invalid of quantity, quantity must be a positive interger!");
                    continue;
                }
            } catch (Exception e) {
                System.err.println("Invalid of quantity , quantity must be a positive interger!");
                continue;
            }
            // check quantity fruit in system is enough fruit to order
            int fruitQuantity = fruitOrder.getQuantity();
            if (quantityOrder > fruitQuantity) {
                String nameFruit = fruitOrder.getName();
                System.err.println("Not enough " + nameFruit + " to order!"
                        + " Quantity must be in range [0 - " + fruitQuantity + "]!");
                continue;
            } else {
                return quantityOrder;
            }
        }
    }
    
    public static Fruit getFruitByNamePriceOrigin(List<Fruit> listForBuyer, String name, double price, String origin) {
        for (Fruit fruit : listForBuyer) {
            if (fruit.getName().equalsIgnoreCase(name) && fruit.getPrice() == price
                    && fruit.getOrigin().equalsIgnoreCase(origin)) {
                return fruit;
            }
        }
        return null;
    }

}
