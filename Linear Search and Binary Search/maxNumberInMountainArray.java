public class maxNumberInMountainArray {
    public static void main(String[] args) {
        int[] arr={2,3,4,5,3,2,1};
       int ans= peakIndexInMountainArray(arr);
       System.out.println(ans);
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

}
