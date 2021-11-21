/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1_S_P0011_change_base_v2;

import java.math.BigInteger;

/**
 *
 * @author PHAM KHAC VINH
 */
public class ManageConvert {

    /*
	 * This function use to convert a number from other base
	 * to base Decimal
	 * 
	 * parameter: number 
	 * parameter: base - base to convert to decimal base
	 * 
	 * return : a BigInteger
	 * **/
    public static BigInteger OtherBaseToDec(String number, int base) {
        BigInteger result = new BigInteger("0");
        BigInteger baseBigInteger = BigInteger.valueOf(base);
        number = number.toUpperCase();

        String HEX = "0123456789ABCDEF";
        //loop to access character from first character to last character in your number
        for (int i = 0; i < number.length(); i++) {
            BigInteger hexIndex = BigInteger.valueOf(HEX.indexOf(number.charAt(i)));
            BigInteger value = baseBigInteger.pow(number.length() - i - 1).multiply(hexIndex);
            result = result.add(value);
        }

        return result;
    }

    /*
	 * This function use to convert from decimal base 
	 * to other base
	 * 
	 * parameter: BigInteger Dec - a BigInteger Decimal
	 * parameter: int base	- base you want to convert to
	 * 
	 * return: a String - number which you convert from decimal 
	 * to base you want
	 * 
	 * **/
    public static String DecToOther(BigInteger Dec, int base) {
        String result = "";
        String HEX = "0123456789ABCDEF";
        //loop until Decimal number <= 0
        while (Dec.compareTo(new BigInteger("0")) > 0) {
            int remainder = Dec.mod(new BigInteger(base + "")).intValue();
            result = HEX.charAt(remainder) + result;
            Dec = Dec.divide(new BigInteger(base + ""));
        }
        return result;
    }

    /*
     * This Function use to select  choice convert from binary number
     * to other base
     * 
     * parameter: String binary - binary number you enter
     * 
     * **/
    public static void convertFromBinary(String binary) {
        int choice = displayConvert("binary", "decimal", "hexadecimal", "binary");
        switch (choice) {
            //convert to decimal
            case 1:
                System.out.println(OtherBaseToDec(binary, 2));
                break;
            // convert to hexadecimal
            case 2:
                System.out.println(DecToOther(OtherBaseToDec(binary, 2), 16));

                break;
            //convert to binary
            case 3:
                System.out.println(binary);

                break;
        }
    }

    /*
     * This Function use to select  choice convert from Decimal number
     * to other base
     * 
     * parameter: String decimal - decimal number you enter
     * 
     * **/
    public static void convertFromDecimal(String decimal) {
        int choice = displayConvert("decimal", "binary", "hexadecimal", "decimal");
        switch (choice) {
            //convert to binary
            case 1:
                System.out.println(DecToOther(OtherBaseToDec(decimal, 10), 2));
                break;
            //convert to hexadecimal
            case 2:
                System.out.println(DecToOther(OtherBaseToDec(decimal, 10), 16));
                break;
            //Convert to decimal
            case 3:
                System.out.println(decimal);
                break;
        }
    }

    /*
     * This Function use to select  choice convert from Hexadecimal number
     * to other base
     * 
     * parameter: String hexa - Hexadecimal number you enter
     * 
     * **/
    public static void convertFromHexa(String hexa) {
        int choice = displayConvert("hexa", "binary", "decimal", "hexa");
        switch (choice) {
            //convert to binary
            case 1:
                System.out.println(DecToOther(OtherBaseToDec(hexa, 16), 2));
                break;
            // convert to decimal
            case 2:
                System.out.println(DecToOther(OtherBaseToDec(hexa, 16), 10));
                break;
            // convert to hexadecimal
            case 3:
                System.out.println(DecToOther(OtherBaseToDec(hexa, 16), 16));
                break;
        }
    }

    /* This function use to select choice which base you want to convert to
     * 
     * parameter: String from - base you convert from
     * parameter : String toCase1 - base you want to convert to
     * parameter : String toCase2 - base you want to convert to
     * parameter : String toCase3 - base you want to convert to
     * 
     * return: option - option you want use
     * **/
    public static int displayConvert(String from, String toCase1, String toCase2, String toCase3) {
        System.out.println("\n");
        System.out.println("1. Convert form " + from + " to " + toCase1);
        System.out.println("2. Convert form " + from + " to " + toCase2);
        System.out.println("3. Convert form " + from + " to " + toCase3);

        int option = GetInput.getInputOption("Input option: ", "Option must be a"
                + " decimal postive number !!", 1, 3);
        return option;
    }

}
