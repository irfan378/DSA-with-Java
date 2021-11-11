import java.util.Scanner;

public class typeCastingAndConversion{
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // float num=input.nextFloat();
        // int num=input.nextInt();
        // System.out.println(num);

        // Type Casting
    //   int num=(int)(67.56f);
    //     System.out.println(num);
        // Automatic type promotion in expressions.
        // int a=257;
        // byte b=(byte)(a);//257%256=1
        // System.out.println(b);

        // byte a=40;
        // byte b=50;
        // byte c=100;
        // int d=a*b/c;

        // int number='A';

        byte b=42;
        char c='a';
        short s=1024;
        int i=50000;
        float f=5.76f;
        double d=0.2344;
        double result=(f*b)+(i/c)-(d*s);

        System.out.println((f*b)+" "+(i/c)+" "+(d*s));
        System.out.println(result);


        // System.out.println(number);
        // System.out.println(23*4.5);

        // System.out.println(d);
    }
}