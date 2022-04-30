import java.util.ArrayDeque;

public class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }

    int size() {
        // write your code here
        return mainQ.size();
    }

    void push(int val) {
        // write your code here
        while (mainQ.size() > 0) {
            helperQ.add(mainQ.remove());
        }
        mainQ.add(val);
        while (helperQ.size() > 0) {
            mainQ.add(helperQ.remove());
        }
    }

    int pop() {
        // write your code here
        if (size() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return mainQ.remove();
        }
    }

    int top() {
        // write your code here
        if (size() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return mainQ.peek();
        }
    }

}
