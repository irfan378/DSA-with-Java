import java.util.Stack;

public class MinumunStack {
    public class minStack {
        Stack<Integer> allData;
        Stack<Integer> minData;

        public minStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }

        int size() {
            return allData.size();
        }

        void push(int val) {
            allData.push(val);
            if (minData.size() == 0 || val <= minData.peek()) {
                minData.push(val);
            }
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = allData.pop();
                if (val == minData.peek()) {
                    minData.pop();
                }
                return val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return allData.peek();
            }
        }

        int min() {
            if (size() == 0) {
                return -1;
            } else {
                return minData.peek();
            }
        }

    }

    public static void main(String[] args) {

    }
}
