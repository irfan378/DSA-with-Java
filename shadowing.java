public class shadowing {
    static int x=90;//this will be shadowed
    public static void main(String[] args) {
        System.out.println(x); //the class variable at line 4 is shadowed by this
        int x;  
        x=40;
        System.out.println(x);
        fun();
    }
    static void fun(){
        System.out.println(x);
    }
}
