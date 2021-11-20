import java.util.Arrays;



public class varArgs {
    public static void main(String[] args) {
        fun(3,56,7,8,5,5);
        fun();
        multiple(201, 222, "irfan","person");
    }
    static void multiple(int a,int b,String ...v){
        System.out.println(a+" "+b+" "+ Arrays.toString(v));
    }
    static void fun(int ...v){
        System.out.println(Arrays.toString(v));
    }
}
