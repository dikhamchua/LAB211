package j1_S_P0001_Bubble_sort_algorithm;

public class Main {

    public static void main(String[] args) {

        //get size of array in range from 1 to 2^31 -1
        int sizeArray = GetInput.getInt("Enter number of array: ",
                "Invalid. Enter again!!", 1, Integer.MAX_VALUE);

        int[] array = new int[sizeArray];

        //test case
        //int[] array = {5,1,12,-5,16};
        //Random elements array
        WorkWithArray.randomArray(array);

        //display array before sorted
        WorkWithArray.displayArray(array, "Unsorted array: ");

        //sort array by using bubble sort algorithm
        WorkWithArray.sortArray(array);

        //display array after sorted
        System.out.println();
        WorkWithArray.displayArray(array, "Sorted array: ");
        
    }
}
