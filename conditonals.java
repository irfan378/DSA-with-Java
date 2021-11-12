import javax.swing.LookAndFeel;

public class conditonals{
    public static void main(String[] args) {
        // int a=10;
        // if (a==10) {
        //     System.out.println("hello world");
        // }

        int salary=25400;
        // if (salary>1000) {
        //   salary=salary+2000;
        // } else {
        //   salary=salary+1000;
        // }
        
        // Multiple if else statement
        if (salary>1000) {
            salary=salary+2000;
          } 
          else if(salary>20000){
            salary+=3000;
          }
            else {
            salary=salary+1000;
          }
          
        System.out.println(salary);
    }
}