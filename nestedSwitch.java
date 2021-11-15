import java.util.Scanner;

public class nestedSwitch{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int empID=in.nextInt();
        String department=in.next();

        switch(empID){
            case 1:
            System.out.println("irfan");
            break;
            case 2:
            System.out.println("someone");
        case 3:
            switch (department) {
                case "IT":
                    System.out.println("IT Department");
                    break;
                case "Managment":
                    System.out.println("Managment Department");
                    break;
            
                default:
                    System.out.println("No Department found");
            }
            break;
            default:
            System.out.println("Enter correct ID");
        }
    }
}