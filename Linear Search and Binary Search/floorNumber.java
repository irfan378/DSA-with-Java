public class floorNumber {
   
        public static void main(String[] args) {
            int[] arr = { -3, -1, 0, 2, 3, 4, 14, 16 };
            int target = -4;
            int ans = search(arr, target);
            System.out.println(ans);
        }
    
        // return the index of greatest no<= target
        static int search(int[] arr, int target) {
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                // find the middle element
                // int mide=(start+end)/2; might be possible that (start+end)/2 exceeds hte
                // range of int in java.
                int mid = start + (end - start) / 2;
                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
            return end;
        }
    
    }
    

