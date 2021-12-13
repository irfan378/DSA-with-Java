import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 6 };
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr) {
        boolean swapped;
        // run the steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            swapped = false;

            // for each step, max item will come at the respective index
            for (int j = 1; j < arr.length - i; j++) {
                // swap if the item is smaller than the previous item.
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            // if you did not swap for a particular value of i, it means the arrays is
            // sorted hence stop the program.
            if (!swapped) { // !false=true
                break;
            }
        }
    }
}