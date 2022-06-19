import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
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

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += "<-" + node.data + "->";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int lsm = sum(node.left);
        int rsm = sum(node.right);
        int tsm = lsm + rsm + node.data;
        return tsm;
    }

    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int lmax = max(node.left);
        int rmax = max(node.right);
        int tm = Math.max(node.data, Math.max(lmax, rmax));
        return tm;
    }

    public static int height(Node node) {
        if (node == null) {
            return -1; // -1 for edges and 0 for nodes
        }
        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static void traversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data + "in Preorder");
        traversal(node.left);
        System.out.println(node.data + "in inorder");
        traversal(node.right);
        System.out.println(node.data + "in Postorder");
    }

    public static void levelOrder(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        while (mq.size() > 0) {
            int count = mq.size();
            for (int i = 0; i < count; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    mq.add(node.left);
                }
                if (node.right != null) {
                    mq.add(node.right);
                }
            }
            System.out.println();

        }
    }

    public static class DiaPair {
        int ht;
        int dia;
    }

    public static DiaPair diameter2(Node node) {
        if (node == null) {
            DiaPair bp = new DiaPair();
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }
        DiaPair lp = diameter2(node.left);
        DiaPair rp = diameter2(node.right);

        DiaPair mp = new DiaPair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;

        int fes = lp.ht + rp.ht + 2;
        mp.dia = Math.max(fes, Math.max(lp.dia, rp.dia));

        return mp;
    }

    public static void iterativePrePostInTreverasls(Node node) {
        Stack<Pair> st = new Stack<>();
        Pair rtp = new Pair(node, 1);
        st.push(rtp);
        String pre = "";
        String in = "";
        String post = "";
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                // pre,state++,left
                pre += top.node.data + " ";
                top.state++;
                if (top.node.left != null) {
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }

            } else if (top.state == 2) {
                // in,state++,right
                in += top.node.data + " ";
                top.state++;
                if (top.node.right != null) {
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }
            } else {
                // post,pop
                post += top.node.data + " ";
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static ArrayList<Node> path;

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            path.add(node);
            return true;
        }
        boolean filc = find(node.left, data);
        if (filc) {
            path.add(node);
            return true;
        }
        boolean firc = find(node.right, data);
        if (firc) {
            path.add(node);
            return true;
        }
        return false;
    }

    public static void printKLevelsDown(Node node, int k, Node block) {
        if (node == null || k < 0 || node == block) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
        }
        printKLevelsDown(node.left, k - 1, block);
        printKLevelsDown(node.right, k - 1, block);

    }

    public static void printKFar(Node node, int data, int k) {
        path = new ArrayList<>();
        find(node, data);
        for (int i = 0; i < path.size(); i++) {
            printKLevelsDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
        }

    }

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sum += node.data;
            if (sum >= lo && sum <= hi) {
                System.out.println(path + node.data);
            }
            return;
        }
        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }

    public static Node createLeftCloneTree(Node node) {
        if (node == null) {
            return null;
        }
        Node lcr = createLeftCloneTree(node.left);
        Node rcr = createLeftCloneTree(node.right);

        Node nn = new Node(node.data, lcr, null);
        node.left = nn;
        node.right = rcr;
        return node;
    }

    public static Node tranBackFromLeftClonedTree(Node node) {
        if (node == null) {
            return null;
        }
        Node lnn = tranBackFromLeftClonedTree(node.left.left);
        Node rnn = tranBackFromLeftClonedTree(node.right);

        node.left = lnn;
        node.right = rnn;

        return node;
    }

    public static void printSingleChildNodes(Node node, Node parent) {
        if (parent != null && parent.left == node && parent.right == null) {
            System.out.println(node.data);
        } else if (parent != null && parent.right == node && parent.left == null) {
            System.out.println(node.data);
        }
        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static Node removeLeaves(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }

    static int tilt = 0;

    public static int tilt(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = tilt(node.left);
        int rs = tilt(node.right);

        int ltilt = Math.abs(ls - rs);
        tilt += ltilt;

        int ts = ls + rs + node.data;
        return ts;
    }

    static boolean isBal = true;

    public static int isBalanced(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = isBalanced(node.left);
        int rh = isBalanced(node.right);

        int gap = Math.abs(lh - rh);
        if (gap > 1) {
            isBal = false;
        }
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static class BalPair {
        int ht;
        boolean isBal;
    }

    public static BalPair isBal(Node node) {
        if (node == null) {
            BalPair bp = new BalPair();
            bp.ht = 0;
            bp.isBal = true;
            return bp;
        }
        BalPair lp = isBal(node.right);
        BalPair rp = isBal(node.left);

        BalPair mp = new BalPair();
        mp.isBal = Math.abs(lp.ht - rp.ht) <= 1 && lp.isBal && rp.isBal;
        mp.ht = Math.max(lp.ht, rp.ht) + 1;
        return mp;
    }

    public static int diameter1(Node node) {
        if (node == null) {
            return 0;
        }
        int ld = diameter1(node.left);
        int rd = diameter1(node.right);
        int f = height(node.left) + height(node.right) + 2;

        int dia = Math.max(f, Math.max(ld, rd));
        return dia;
    }

    public static class BSTPair {
        boolean isBST;
        int min;
        int max;
    }

    public static BSTPair isBST(Node node) {
        if (node == null) {
            BSTPair bp = new BSTPair();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.isBST = true;
            return bp;
        }
        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (node.data >= lp.max && node.data <= rp.min);

        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

        return mp;
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
            iterativePrePostInTreverasls(root);
        }
    }
}