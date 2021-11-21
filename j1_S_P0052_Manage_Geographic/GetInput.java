package j1_S_P0052_Manage_Geographic;

import java.util.Scanner;

public class GetInput {

    /**
     * User enter the option
     *
     * @param
     * @return option
     */
    static Scanner scanner = new Scanner(System.in);

    public static int selectOption() {
        Scanner scanner = new Scanner(System.in);

        // ask user until true input
        while (true) {
            System.out.print("Select option: ");
            try {
                String input = scanner.nextLine().trim();
                //if input is empty or have only space => tell user
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    int option = Integer.parseInt(input);
                    // check the range of input
                    if (1 <= option && option <= 5) {
                        return option;
                    } else {
                        System.out.println("Invalid. The input must be "
                                + "in range " + 1 + " to " + 5);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid. The option must"
                        + " be decimal postive number!!!");
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
                    if (min < floatInput && floatInput <= max) {
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

}
