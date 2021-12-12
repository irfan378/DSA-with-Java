import java.util.Arrays;

public class firstAndLastPositionInSortedArray {
    public static void main(String[] args) {
        int[] arr={2,3,4,4,4,4,5,6};
        int target=4;
        int[] ans=new int[2];
        ans=searchRange(arr,target);
        System.out.println(Arrays.toString(ans));
    }
    static public int[] searchRange(int[] nums,int target){

        int[] ans={-1,-1};

        // check for first occurance if target found
        ans[0]=search(nums, target,true);
        if (ans[0]!=-1) {
            ans[1]=search(nums, target, false);
        }
        return ans;

        
    }
    // this function just returns the index value of the target
   static public int search(int[] nums,int target,boolean findStartindex){
        int ans=-1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            
            // find the middle element
            // int mid=(start+end)/2; might be possible that (start+end)/2 exceeds hte
            // range of int in java.
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target> nums[mid]) {
                start = mid + 1;
            } else {
                // potential ans is found
                ans=mid;
                if(findStartindex==true){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}
