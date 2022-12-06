import java.util.Scanner;

public class coinChangePermutations {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] coin = new int[n];
        for (int i = 0; i < coin.length; i++) {
            coin[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        scn.close();
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for (int amt = 0; amt <= tar; amt++) {
            for (int coins : coin) {
                if (coins <= amt) {
                    int ramt = amt - coins;
                    dp[amt] += dp[ramt];
                }
            }
        }
        System.out.println(dp[tar]);
    }
}
