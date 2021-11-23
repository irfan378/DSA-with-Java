import java.util.ArrayList;
import java.util.Scanner;

public class  arraylist{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>(5);

        // list.add(3);
        // list.add(6);
        // list.add(7);
        // list.add(10);
        // list.add(29);
        // System.out.println(list.contains(3));
        // list.set(0, 99);
        // list.remove(2);
        // System.out.println(list);

        // input
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }

        // get item at any index
        for (int i = 0; i < 5; i++) {
                System.out.println(list.get(i));//pass index here ,list[index] syntax will not work here
        }
        System.out.println(list);
    }
}