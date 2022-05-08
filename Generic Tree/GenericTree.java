import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class GenericTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node node) {
        String str = node.data + "->";
        for (Node child : node.children) {
            str += child.data + ",";
        }
        str += ".";
        System.out.println(str);
        for (Node child : node.children) {
            display(child);
        }
    }

    public static int size(Node node) {
        int size = 0;
        for (Node child : node.children) {
            int childSize = size(child);
            size = size + childSize;
        }
        size = size + 1;
        return size;
    }

    public static int max(Node node) {
        int max = Integer.MIN_VALUE;
        for (Node child : node.children) {
            int childMax = max(child);
            max = Math.max(childMax, max);
        }
        max = Math.max(node.data, max);
        return max;
    }

    public static int height(Node node) {
        int height = -1;
        for (Node child : node.children) {
            int childHeight = height(child);
            height = Math.max(height, childHeight);
        }
        height += 1;
        return height;
    }

    public static void traversals(Node node) {
        // euler's left,on the way deep in the recursion,node's pre area
        System.out.println("Node pre" + node.data);
        for (Node child : node.children) {
            // edge pre
            System.out.println("Edge Pre" + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post" + node.data + "--" + child.data);
            // edge post
        }
        System.out.println("Node Post" + node.data);
        // euler's right,on the way out of recursion,node's post area
    }

    public static void levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while (q.size() > 0) {
            node = q.remove();
            System.out.print(node.data + " ");
            for (Node child : node.children) {
                q.add(child);
            }
        }
        System.out.println(".");
    }

    public static void levelOrderLineWise(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        Queue<Node> cq = new ArrayDeque<>();
        while (mq.size() > 0) {
            mq.remove(node);
            System.out.print(node.data + " ");
            for (Node child : node.children) {
                cq.add(child);
            }
            if (mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    public static void levelOrderLineWiseZZ(Node node) {
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
        int level = 1;

        while (ms.size() > 0) {
            node = ms.pop();
            System.out.print(node.data + " ");
            if (level % 2 == 1) {
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            } else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            if (ms.size() == 0) {
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void levelOrderLineWise2(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        mq.add(new Node(-1));
        while (mq.size() > 0) {
            node = mq.remove();
            if (node.data != -1) {
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    mq.add(child);
                }
            } else {
                if (mq.size() > 0) {
                    mq.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }

    public static void levelOrderLineWise3(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        while (mq.size() > 0) {
            int cicl = mq.size();
            for (int i = 0; i < cicl; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    mq.add(child);
                }
            }
            System.out.println();
        }
    }

    private static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void levelOrderLineWise4(Node node) {
        Queue<Pair> mq = new ArrayDeque<>();
        mq.add(new Pair(node, 1));
        int level = 1;
        while (mq.size() > 0) {
            Pair p = mq.remove();
            if (p.level > level) {
                level = p.level;
                System.out.println();
            }
            System.out.println(p.node.data + " ");
            for (Node child : node.children) {
                Pair cp = new Pair(child, p.level + 1);
                mq.add(cp);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 10, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        Stack<Node> st = new Stack<>();
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];
                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }

        }
        int sz = height(root);
        // display(root);
        System.out.println(sz);

    }
}