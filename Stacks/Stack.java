public class Stack {
    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        void push(int val) {
            if (tos == data.length - 1) {
                System.out.println("Stack Overflow");
            } else {
                tos++;
                data[tos] = val;
            }
        }

        void dynamicPush(int val) {
            if (tos == data.length - 1) {
                int[] ndata = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    ndata[i] = data[i];
                }
                data = ndata;
                tos++;
                data[tos] = val;
            } else {
                tos++;
                data[tos] = val;
            }
        }

        int size() {
            return tos + 1;
        }

        void display() {
            for (int i = tos; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        int pop() {
            if (tos == -1) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = data[tos];
                tos--;
                return val;
            }
        }

        int top() {
            if (tos == -1) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = data[tos];
                return val;
            }
        }
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(5);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        stack.pop();
        stack.display();

    }
}