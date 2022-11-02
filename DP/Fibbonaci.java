import java.util.Scanner;

public class Fibbonaci {
    public static int Fib(int n, int[] qb) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
       
        int fib1 = Fib(n - 1, qb);
        int fib2 = Fib(n - 2, qb);
        int fib = fib1 + fib2;
        qb[n] = fib;
        return fib;
    }

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int fibn = Fib(n, new int[n + 1]);
            System.out.println(fibn);
        }
    }
}