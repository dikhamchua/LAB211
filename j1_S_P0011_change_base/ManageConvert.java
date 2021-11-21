/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_S_P0011_change_base;

import java.math.BigInteger;

/**
 *
 * @author PHAM KHAC VINH
 */
public class ManageConvert {

    public static void base_convert(String num, int baseNumberInput, int baseNumberOut) {
        BigInteger number = new BigInteger(num, baseNumberInput);
        System.out.println(number.toString(baseNumberOut).toUpperCase());

    }

    public static void convertFromBinary(String binary) {
        int choice = displayConvert("binary", "decimal", "hexadecimal", "binary");
        switch (choice) {
            case 1:
                base_convert(binary, 2, 10);
                break;
            case 2:
                base_convert(binary, 2, 16);

                break;
            case 3:
                base_convert(binary, 2, 2);

                break;
        }
    }

    public static void convertFromDecimal(String decimal) {
        int choice = displayConvert("decimal", "binary", "hexadecimal", "decimal");
        switch (choice) {
            case 1:
                base_convert(decimal, 10, 2);
                break;
            case 2:
                base_convert(decimal, 10, 16);
                break;
            case 3:
                base_convert(decimal, 10, 10);
                break;
        }
    }

    public static void convertFromHexa(String hexa) {
        int choice = displayConvert("hexa", "binary", "decimal", "hexa");
        switch (choice) {
            case 1:
                base_convert(hexa, 16, 2);
                break;
            case 2:
                base_convert(hexa, 16, 10);
                break;
            case 3:
                base_convert(hexa, 16, 16);
                break;
        }
    }

    public static int displayConvert(String from, String toCase1, String toCase2, String toCase3) {
        System.out.println("1. Convert form " + from + " to " + toCase1);
        System.out.println("2. Convert form " + from + " to " + toCase2);
        System.out.println("3. Convert form " + from + " to " + toCase3);

        int option = GetInput.getInputOption("Input option: ", "Option must be a"
                + " decimal postive number !!", 1, 3);
        return option;
    }

}
