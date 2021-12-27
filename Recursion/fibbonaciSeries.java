public class fibbonaciSeries {
    public static void main(String[] args) {
        System.out.println(fibbonaci(6));
    }

    static int fibbonaci(int n) {
        // base condition
        if (n < 2) {
            return n;
        }
        return fibbonaci(n - 1) + fibbonaci(n - 2);
    }

}
