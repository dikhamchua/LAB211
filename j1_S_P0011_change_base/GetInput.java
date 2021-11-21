	package j1_S_P0011_change_base;

import java.util.Scanner;

public class GetInput {
    //REGEX: 0-9: Matches a character in the range (0-9)
    // A-F : Matches a character in the range (A-F) 
    // + : Match 1 or more preceding token
    //[0-1]: Matches a character in the range 0-1
    private final static Scanner in = new Scanner(System.in);
    private static final String BINARY_VALID = "[0-1]+";
    private static final String DECIMAL_VALID = "[0-9]+";
    private static final String HEXADECIMAL_VALID = "[0-9A-F]+";
    
    public static String InputBinary() {
        System.out.print("Enter number binary: ");
        String result;

        //loop until user input correct
        while (true) {
            result = in.nextLine().trim().replaceAll("\\s+", " ");
            while (checkEmpty(result)) {
                System.out.println("Enter again!");
                result = in.nextLine().trim().replaceAll("\\s+", " ");
            }
            if (result.matches(BINARY_VALID)) {
                return result;
            }
            System.err.println("Must be enter 0 or 1");
            System.out.print("Enter again: ");
        }
    }
    
    public static int inputOption() {
        System.out.println("\n\n=================================================");
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexa.");
        System.out.println("4. Exit");
        
        int choice = GetInput.getInputOption("Enter your choice: ", 
                "Choice must be a decimal postive number", 1, 4);
        return choice;
    }
    
    public static int getInputOption(String msgString, String errorString,
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
    
    static int GetInputBase(String msg) {
        Scanner scanner = new Scanner(System.in);

        // ask user until true input
        while (true) {
            System.out.print(msg);
            try {
                String input = scanner.nextLine().trim();
                //if input is empty or have only space => tell user
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    int number = Integer.parseInt(input);
                    // check the range of input
                    if (number == 2 || number == 10 || number == 16) {
                        return number;
                    } else {
                        System.out.println("Invalid. The input must be "
                                + "in (2,10,16)");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Input must be decimal postive number");
            }
        }

    }

    static String GetInputString(String msg, String err, String regex) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        // loop until true
        while (true) {
            System.out.print(msg);
            String inputString = scanner.nextLine();
            //if input is empty then tell user,
            //else if check regex , else tell error
            if (inputString.isEmpty()) {
                System.out.println("Input cannot be empty!!");
            } else if (inputString.matches(regex)) {
                return inputString;
            } else {
                System.out.println(err);
            }

        }

    }
    
    public static boolean checkEmpty(String s) {
        if (s.isEmpty() || s.equals("")) {
            System.out.println("Don't empty!");
            return true;
        }
        return false;

    }
    public static String InputDecimal() {
        System.out.print("Enter number decimal: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim().replaceAll("\\s+", " ");
            while (checkEmpty(result)) {
                System.out.println("Enter again!");
                result = in.nextLine().trim().replaceAll("\\s+", " ");
            }
            if (result.matches(DECIMAL_VALID)) {
                return result;
            }
            System.err.println("Must be enter 0-9");
            System.out.print("Enter again: ");
        }
    }
    
    public static String InputHexaDecimal() {
        System.out.print("Enter number hexadecimal: ");
        String result;
        //loop until user input correct
        while (true) {
            result = in.nextLine().trim().replaceAll("\\s+", " ");
            while (checkEmpty(result)) {
                System.out.println("Enter again!");
                result = in.nextLine().trim().replaceAll("\\s+", " ");
            }
            if (result.matches(HEXADECIMAL_VALID)) {
                return result;
            }
            System.err.println("Must be enter 0-9 A-F");
            System.out.print("Enter again: ");
        }
    }

}
