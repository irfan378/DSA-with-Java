import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, true);
        }
        for (int val : arr) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }
        int maxStartPt = 0;
        int maxLen = 0;
        for (int val : arr) {
            if (map.get(val) == true) {
                int tempLen = 1;
                int tempStPt = val;
                while (map.containsKey(tempLen + tempStPt)) {
                    tempLen++;
                }
                if (tempLen > maxLen) {
                    maxStartPt = tempStPt;
                    maxLen = tempLen;
                }

            }
        }
        for (int i = 0; i < maxLen; i++) {
            System.out.println(maxStartPt + i);
        }

    }

}
