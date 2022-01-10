public class setBits {
    public static void main(String[] args) {
        int n = 348483;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(SetBits(n));
    }

    public static int SetBits(int n) {
        int count = 0;
        // while (n > 0) {
        // count++;
        // n -= (n & -n);
        // }
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
