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

    public static void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(child);
            }
        }
        for (Node child : node.children) {
            removeLeaves(child);
        }
    }

    public static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }
        while (node.children.size() > 1) {
            Node lc = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node slt = getTail(sl);
            slt.children.add(lc);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }

    public static Node linearize2(Node node) {
        if (node.children.size() == 0) {
            return node;
        }
        Node lastChildTail = linearize2(node.children.get(node.children.size() - 1));
        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node secondLast = node.children.get(node.children.size() - 1);
            Node secondLastTail = linearize2(secondLast);
            secondLastTail.children.add(last);
        }
        return lastChildTail;
    }

    public static boolean find(Node node, int data) {
        if (node.data == data) {
            return true;
        }
        for (Node child : node.children) {
            boolean findInChild = find(child, data);
            if (findInChild) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }
        return new ArrayList<>();
    }

    public static int lowestCommonAncestor(Node node, int d1, int d2) {
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return p1.get(i);
    }

    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return i + j;
    }

    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);
            if (areSimilar(c1, c2) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }
        for (int i = 0; i < n1.children.size(); i++) {
            int j = n2.children.size() - 1 - i;
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            if (areMirror(c1, c2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSymmetric(Node node) {
        return areMirror(node, node);
    }

    static Node predecessor;
    static Node sucessor;
    static int state;

    public static void predecessorAndSucessor(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state = 1;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            sucessor = node;
            state = 2;
        }
        for (Node child : node.children) {
            predecessorAndSucessor(child, data);
        }
    }

    static int ceil;
    static int floor;

    public static void ceilAndFloor(Node node, int data) {
        if (node.data > data) {
            if (node.data < ceil) {
                ceil = node.data;
            }
        }
        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }
        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }

    public static int kthLargest(Node node, int k) {
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ceilAndFloor(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }

    static int msn = 0;
    static int ms = Integer.MIN_VALUE;

    public static int retSumAndCalculateMSST(Node node) {
        int sum = 0;

        for (Node child : node.children) {
            int csum = retSumAndCalculateMSST(child);
            sum += csum;
        }
        sum += node.data;
        if (sum > ms) {
            msn = node.data;
            ms = sum;
        }
        return sum;
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