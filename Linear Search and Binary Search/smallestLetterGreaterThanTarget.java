public class smallestLetterGreaterThanTarget {
    
        public static void main(String[] args) {
            char[] arr = {'c','f','j'};
            char target = 'c';
            char ans = search(arr, target);
            System.out.println(ans);
        }
    
        // return the character of smallest character>= target
        static char search(char[] arr, char target) {
            // but if the target is greater than the greatest character in the array then return the first character
          
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                // find the middle element
                // int mid=(start+end)/2; might be possible that (start+end)/2 exceeds the range of int in java.
                int mid = start + (end - start) / 2;
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                } 
            }
           
            return arr[start % arr.length];
        }
    
  
    


}
