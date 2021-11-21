package j1_S_P0001_Bubble_sort_algorithm;

import java.util.Scanner;

public class GetInput {

    static Scanner scanner = new Scanner(System.in);

    // get an int number
    protected static int getInt(String msgString, String errorString,
            int min, int max) {
        // loop until false
        while (true) {
            System.out.println(msgString);
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                // if the number is true then return, else tell user
                // and enter again
                if (min <= number && number <= max) {
                    return number;
                } else {
                    System.out.println("The number must be in range "
                            + min + " to " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorString);
            }
        }

    }
}
