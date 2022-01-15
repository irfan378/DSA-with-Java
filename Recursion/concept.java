public class concept {
    public static void main(String[] args) {
        fun(5);
    }

    static void fun(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        // fun(n--); // this will print first and then subtract and it will cause
        // infinite recursion and it will print 5 5 5 5 5.
        fun(--n);
    }
}
