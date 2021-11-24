public class linearSearch {
    public static void main(String[] args) {
        int[] nums={23,45,1,2,8,5,65,56,-32,-2,45};
        int target=65;
        System.out.println(Search2(nums, target));
    }
    // return the element 
    static int Search2(int[] arr,int target){
        if (arr.length==0) {
            return -1;
        }
        // run a for loop
        for (int i = 0; i < arr.length; i++) {
                //check for element at every index if it is = target
                int element=arr[i];
                if(element==target){
                    return element;
                }
            }
            // this line will execute if none of the return statements above have executed
            // hence the target not found
            return -1;
        }
        // Search in the array.
        // Otherwise if item not found return -1.
        
        // return the index
    static int Search(int[] arr,int target){
        if (arr.length==0) {
            return -1;
        }
        // run a for loop
        for (int i = 0; i < arr.length; i++) {
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

