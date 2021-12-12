public class InfiniteArraySearch {
    public static void main(String[] args) {
        int[] arr={3,4,5,5,6,7,8,9,10};
        int target=10;
        System.out.println(findingRange(arr, target));

    }
    static int findingRange(int[] arr,int target){
        // first find the range
        // first start with a box of 2.
        int start=0;
        int end=1;
        while(target>arr[end]){
            int newStart=end+1;//this is my new start
            // double the box value
            // end= previous end+sizeofbox*2
            end=end+(end-start+1)*2;
            start=newStart;
        }  
        return search(arr,target,start,end);
    }

     static int search(int[] arr, int target,int start,int end) {
        while (start <= end) {
            // find the middle element
            // int mid=(start+end)/2; might be possible that (start+end)/2 exceeds hte
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
        return -1;
    }
}
