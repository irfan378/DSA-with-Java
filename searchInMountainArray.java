public class searchInMountainArray {
    public static void main(String[] args) {
        int[] arr={2,3,4,5,3,2,1};
        int target=5;
        int ans= search(arr,target);
        System.out.println(ans);
    }
    static int search (int[] arr,int target){
        int peak=peakIndexInMountainArray(arr);
        int firstTry=Binarysearch(arr, target,0,peak);

        if (firstTry!=-1) {
            return firstTry;
        }
        // try to search in second half
        return Binarysearch(arr, target, peak+1, arr.length-1);

    }
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // you are in decreasing part of array.
                // this may be the answer ,but look at left
                // this is why end!= mid-1
                end = mid;
            } else {
                // you are in asc part of the array
                start = mid + 1;// because we know that mid+1 element > mid element
            }
        }
        // in the end ,start== end and pointing to the largest number because of the 2
        // checks above
        // start and end are always trying to find the max element in the above two
        // checks
        // hence they are pointing to just one element ,that is the max one because that
        // is what the checks say.
        // At every point of time for start and end ,they have the best possible answer
        // till that time and if we r saying only one item remaining,hence because of
        // above line that is the best possible answer
        return start;// or return end as both r equal
    }
    static int Binarysearch(int[] arr, int target,int start,int end) {
       
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

