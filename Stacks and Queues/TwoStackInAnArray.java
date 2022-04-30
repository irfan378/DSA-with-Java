public class TwoStackInAnArray {
    int[] data;
    int tos1;
    int tos2;

    public TwoStackInAnArray(int cap) {
        // write your code here
        data = new int[cap];
        tos1 = -1;
        tos2 = data.length;
    }

    int size1() {
        // write your code here
        return tos1 + 1;
    }

    int size2() {
        // write your code here
        return data.length - tos2;
    }

    void push1(int val) {
        // write your code here
        if (tos2 == tos1 + 1) {
            System.out.println("Stack Overflow");
        } else {
            tos1++;
            data[tos1] = val;
        }
    }

    void push2(int val) {
        // write your code here
        if (tos2 == tos1 + 1) {
            System.out.println("Stack Overflow");
        } else {
            tos2--;
            data[tos2] = val;
        }
    }

    int pop1() {
        // write your code here
        if (size1() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int val = data[tos1];
            tos1--;
            return val;
        }
    }

    int pop2() {
        // write your code here
        if (size2() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int val = data[tos2];
            tos2++;
            return val;
        }
    }

    int top1() {
        // write your code here
        if (size1() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int val = data[tos1];
            return val;
        }
    }

    int top2() {
        // write your code here
        if (size2() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int val = data[tos2];
            return val;
        }
    }
}
