import java.util.Stack;

public class celebrity {
    public static void findCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                // if i knows j -> i is not a celbrity
                st.push(j);
            } else {
                // if i doesnot know j -> j is not a celbrity
                st.push(i);
            }
        }
        int pot = st.pop();
        for (int i = 0; i < arr.length; i++) {
            if (i != pot) {
                if (arr[i][pot] == 0 || arr[pot][i] == 1) {
                    System.out.println("None");
                    return;
                }
            }
        }
        System.out.println(pot);
    }

    public static void main(String[] args) {

    }
}
