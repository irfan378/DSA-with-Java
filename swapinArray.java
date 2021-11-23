import java.util.Arrays;

public class swapinArray {
    public static void main(String[] args) {
        int[] arr={1,3,24,4,5};
        swap(arr,0,3);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr,int index1,int index3){
        int temp=arr[index1];
        arr[index1]=arr[index3];
        arr[index3]=temp;    
    }
}
