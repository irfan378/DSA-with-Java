import java.util.Stack;

public class BinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };

        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int index = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                index++;
                if (arr[index] != null) {
                    Node ln = new Node(arr[index], null, null);
                    top.node.left = ln;

                    Pair lp = new Pair(ln, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                index++;
                if (arr[index] != null) {
                    top.node.right = new Node(arr[index], null, null);

                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }
    }
}