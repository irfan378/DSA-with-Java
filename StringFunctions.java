import java.util.Scanner;

public class StringFunctions {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter your name");
        String name=in.next();
        String personalised=myGreet(name);
        System.out.println(personalised);
    }
    static String myGreet(String name){
        String message=" hello " + name;
        return message;
    }
}
