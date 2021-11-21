import java.util.Arrays;
import java.util.Scanner;

public class inputArrays {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[]arr=new int[5];
        // input using for loops
        for (int i = 0; i < arr.length; i++) {
            arr[i]=in.nextInt();
        }
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // for(int num : arr){//for every element in array,print the element
        //     System.out.print(num+ " ");//here num represents element of the array
        // }
        System.out.println(Arrays.toString(arr));
    }
}
