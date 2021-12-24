import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b');
        System.out.println("a" + "b");
        System.out.println('a' + 3);
        System.out.println((char) ('a' + 3));
        System.out.println("a" + 1);
        System.out.println("irfan" + new ArrayList<>());
        System.out.println("irfan" + new Integer(56));
        // System.out.println(new Integer(56) + new ArrayList<>());
        // This will throw error '+' will work only if at least one of them is string
        System.out.println(new Integer(56) + "" + new ArrayList<>());
    }

}
