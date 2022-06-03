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
    public static void levelOrder(Node node){
        Queue<Node> mq=new ArrayDeque<>();
        mq.add(node);
        while (mq.size()>0) {
            int count=mq.size();
            for (int i = 0; i < count; i++) {
                node=mq.remove();
                System.out.print(node.data+" ");
                if (node.left!=null) {
                    mq.add(node.left);
                }
                if (node.right!=null) {
                    mq.add(node.right);
                }
            }
            System.out.println();
            
        }
    }
    public static void iterativePrePostInTreverasls(Node node){
        Stack<Pair> st=new Stack<>();
        Pair rtp=new Pair(node, 1);
        st.push(rtp);
        String pre="";
        String in="";
        String post="";
        while (st.size()>0) {
            Pair top=st.peek();
            if (top.state==1) {
                // pre,state++,left
                pre+=top.node.data+" ";
                top.state++;
                if (top.node.left!=null) {
                    Pair lp=new Pair(top.node.left, 1);
                    st.push(lp);
                }

            }else if (top.state==2) {
                // in,state++,right
                in+=top.node.data+" ";
                top.state++;
                if (top.node.right!=null) {
                    Pair rp=new Pair(top.node.right, 1);
                    st.push(rp);
                }
            }else{
                // post,pop
                post+=top.node.data+" ";
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
    static ArrayList<Integer> path;
    public static boolean find(Node node,int data){
        if (node==null) {
            return false;
        }
        if (node.data==data) {
            path.add(node.data);
            return true;
        }
        boolean filc=find(node.left, data);
        if (filc) {
            path.add(node.data);
            return true;
        }
        boolean firc=find(node.right, data);
        if (firc) {
            path.add(node.data);
            return true;
        }
        return false;
    }
 public static void printKLevelsDown(Node node,int k){
    if (node==null||k<0) {
        return;
    }
    if (k==0) {
        System.out.println(node.data);
    }
    printKLevelsDown(node.left, k-1);
    printKLevelsDown(node.right, k-1);

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