import java.util.jar.Attributes.Name;

public class functionOverloading {
    public static void main(String[] args) {
        fun("irfan");
        fun(3);
        // fun();this will throw an error and it is called ambuigity

    }
    static void  fun(int a){
        System.out.println(a);
    }
    static void fun(String name){
        System.out.println(name);
    }
}
