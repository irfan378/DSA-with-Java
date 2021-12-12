public class orderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr={ -3, -1, 0, 2, 3, 4, 15, 16 };
        int target=4;
        int ans = search(arr, target);
        System.out.println(ans);
    }
     // return the index
    // return -1 if it does not exist.
    static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        //   find wheather the array is sorted in ascending or descending.
    boolean isAsc=arr[start]<arr[end];

        while (start <= end) {
            // find the middle element
            // int mide=(start+end)/2; might be possible that (start+end)/2 exceeds hte
            // range of int in java.
            int mid = start + (end - start) / 2;
            
            if (arr[mid]==target) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                }
                else if (target > arr[mid]) {
                    start = mid + 1;
                } 
            }
          else{
            if (target > arr[mid]) {
                end = mid - 1;
            }
            else if (target < arr[mid]) {
                start = mid + 1;
            } 
          }
        }
        return -1;
    }

}
