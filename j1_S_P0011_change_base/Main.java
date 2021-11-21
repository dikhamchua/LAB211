package j1_S_P0011_change_base;
/*
 * Copyright(C) 2021,  <FPT UNIVERSITY>.
 * J1.S.P0011
 * Write a program to convert base (Use Function)
 * Record of change:
 * DATE			Version		AUTHOR		DESCRIPTION
 * 2021/10/27     v1		Vinh		Initialization               

 */

public class Main {
    //REGEX: 0-9: Matches a character in the range (0-9)
    // A-F : Matches a character in the range (A-F) 
    // + : Match 1 or more preceding token

    public static final String INPUT_VALUE = "[0-9A-F]+";

    public static void main(String[] args) {
        while (true) {
            //Step 1: input your option
            int option = GetInput.inputOption();
            switch (option) {
                case 1:
                    //Step 2 : Input binary number
                    String binary = GetInput.InputBinary();
                    //Covert from binary number to decimal number or hexa decimal number
                    ManageConvert.convertFromBinary(binary);
                    break;
                case 2:
                    //Step 3: Input decimal number
                    String decimal = GetInput.InputDecimal();
                    //convert from decimal number to binary number or hexa decimal number
                    ManageConvert.convertFromDecimal(decimal);
                    break;
                case 3:
                    //Step 4: Input hexa decimal number
                    String hexa = GetInput.InputHexaDecimal();
                    //convert from hexa decimal number to decimal number or binary number
                    ManageConvert.convertFromHexa(hexa);
                    break;
                case 4:
                    System.exit(0);
                    return;
            }

        }
    }
}
