import java.util.Scanner;

public class switches {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fruit = in.next();
        switch (fruit) {
        case "Mango":
            System.out.println("king of fruits");
            break;
        case "Apple":
            System.out.println("A sweet red fruit");
            break;
        case "Orange":
            System.out.println("Round fruit");
            break;
        case "Grapes":
            System.out.println("A small fruit");
        default:
            System.out.println("Please enter a valid fruit");
        }
        // int day=in.nextInt();
        // switch(day){
        //     case 1,2,3,4,5 -> System.out.println("week day");
        //     case 6,7->System.out.println("Weekend");
        // }
        
    }
}
