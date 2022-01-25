import java.util.Arrays;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 1 };
        Sort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void Sort(int[] arr, int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                // Swap
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            Sort(arr, r, c + 1);
        } else {
            Sort(arr, r - 1, 0);
        }
    }
}
