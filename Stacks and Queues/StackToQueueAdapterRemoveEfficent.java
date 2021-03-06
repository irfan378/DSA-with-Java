public class StackToQueueAdapterRemoveEfficent {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
        // write your code here
        return mainS.size();
    }

    void add(int val) {
        // write your code here
        while (mainS.size() > 0) {
            helperS.push(mainS.pop());
        }
        mainS.push(val);
        while (helperS.size() > 0) {
            mainS.push(helperS.pop());
        }
    }

    int remove() {
        // write your code here
        if (size() == 0) {
            System.out.println("Queue Underflow");
            return -1;
        } else {
            return mainS.pop();
        }
    }

    int peek() {
        // write your code here
        if (size() == 0) {
            System.out.println("Queue Underflow");
            return -1;
        } else {
            return mainS.peek();
        }
    }
}
