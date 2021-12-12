public class LinearSearchInRange {
    public static void main(String[] args) {
        int[] nums={23,45,1,2,8,5,65,56,-32,-2,45};
        int target=65;
        
        System.out.println(Search(nums, target,1,8));
    }
        // return the index
        static int Search(int[] arr,int target,int start,int end){
            if (arr.length==0) {
                return -1;
            }
            // run a for loop
            for (int i = start; i <=end; i++) {
                    //check for element at every index if it is = target
                    int element=arr[i];
                    if(element==target){
                        return i;
                    }
                }
                // this line will execute if none of the return statements above have executed
                // hence the target not found
                return -1;
            }

}
