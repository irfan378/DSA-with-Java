public class Comparison {
    public static void main(String[] args) {
        String a = "irfan";
        String b = "irfan";
        String c = a;
        System.out.println(a == c);
        // System.out.println(a == b);
        String name1 = new String("irfan");
        String name2 = new String("irfan");
        System.out.println(name1 == name2);
        System.out.println(name1.equals(name2));
        System.out.println(name1.charAt(1));
    }
}