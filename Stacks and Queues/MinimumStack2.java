import java.util.Stack;

public class MinimumStack2 {
    public class minStack2 {
        Stack<Integer> data;
        int min;

        public minStack2() {
            data = new Stack<>();
        }

        int size() {
            return data.size();
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else if (data.peek() >= min) {
                return data.peek();
            } else {
                return min;
            }
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                if (data.peek() >= min) {
                    return data.pop();
                } else {
                    int ov = min;
                    min = 2 * min - data.pop();
                    return ov;
                }
            }
        }

        void push(int val) {
            if (data.size() == 0) {
                data.push(val);
                min = val;
            } else if (val >= min) {
                data.push(val);
            } else {
                data.push(val + val - min); // detection,storing a fake smaller value
                min = val;// original value stored in min
            }
        }

        int min() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return min;
            }
        }

    }

    public static void main(String[] args) {

    }
}
