package j1_S_P0011_change_base_v2;

/*
 * Copyright(C) 2021,  <FPT UNIVERSITY>.
 * J1.S.P0011
 * Write a program to convert base ( USE Algorithm)
 * Record of change:
 * DATE			Version		AUTHOR		DESCRIPTION
 * 2021/10/27           v1		Vinh		Initialization               

 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            //Step 1: input your option
            int option = GetInput.inputOption();
            switch (option) {
                case 1:
                    //Step 2 : Input binary number
                    String binary = GetInput.InputBinary();
                    //Covert from binary number to decimal number or hexadecimal number
                    ManageConvert.convertFromBinary(binary);
                    break;
                case 2:
                    //Step 3: Input decimal number
                    String decimal = GetInput.InputDecimal();
                    //convert from decimal number to binary number or hexadecimal number
                    ManageConvert.convertFromDecimal(decimal);
                    break;
                case 3:
                    //Step 4: Input hexadecimal number
                    String hexa = GetInput.InputHexaDecimal();
                    //convert from hexadecimal number to decimal number or binary number
                    ManageConvert.convertFromHexa(hexa);
                    break;
                case 4:
                    System.exit(0);
                    return;
            }

        }
    }
}
