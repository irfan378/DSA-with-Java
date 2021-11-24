public class findMinNum {
    public static void main(String[] args) {
            int[] arr={23,45,1,2,8,5,65,56,-32,-2,45};
            System.out.println(min(arr));
    }
    // assume arr.length!=0
    // return the minimum value in the arrat
    static int min(int[] arr){
        int ans=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<ans) {
                ans=arr[i];
            }
        }
        return ans;
    }

}
