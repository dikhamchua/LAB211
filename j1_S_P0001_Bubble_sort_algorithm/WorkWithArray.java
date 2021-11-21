package j1_S_P0001_Bubble_sort_algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WorkWithArray {

    // Sort an array
    protected static void sortArray(int[] array) {
        //Loop to access each array elements
        for (int i = 0; i < array.length-1; i++) {

            // loop from first to last unsorted elements
            for (int j = 0; j < array.length - i - 1; j++) {
                // display each step
                //System.out.println(Arrays.toString(array));
                // compare one pair of number
                // if the before number bigger next number then exchange

                if (array[j] > array[j + 1]) {
                    //System.out.println(array[j] + " > " + array[j+1] +",swap");
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else {
                    //System.out.println(array[j]+" < "+ array[j+1]+ ", ok");
                }
            }
        }
    }

    // display an array with a message
    protected static void displayArray(int[] array, String message) {
        System.out.print(message);
        System.out.print(Arrays.toString(array));
    }

    // add random elements into array
    protected static void randomArray(int[] array) {
        Random random = new Random();
        //Loop to access each array elements
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }

    }

}
