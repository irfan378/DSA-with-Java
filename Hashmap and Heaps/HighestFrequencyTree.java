import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyTree {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(0);
            if (hm.containsKey(ch)) {
                int oldFreq = hm.get(ch);
                int newFreq = oldFreq + 1;
                hm.put(ch, newFreq);
            } else {
                hm.put(ch, 1);
            }
        }
        char mostFreqChar = str.charAt(0);
        for (Character key : hm.keySet()) {
            if (hm.get(key) > hm.get(mostFreqChar)) {
                mostFreqChar = key;
            }
        }
        System.out.println(mostFreqChar);
    }
}
