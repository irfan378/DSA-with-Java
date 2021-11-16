import java.util.Scanner;

public class functions {
    public static void main(String[] args) {
       int ans=sum();
       System.out.println("The sum is "+ ans);
       int ans2=sum2(2,3);
       System.out.println(ans2);
    }
    // pass the  value of numbers when you are calling the method in main()
    static int sum2(int a,int b){
        int sum=a+b;
        return sum;
    }

    static int sum() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int num1 = in.nextInt();
        System.out.println("Enter number 2: ");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        
        return sum;

    }
}
