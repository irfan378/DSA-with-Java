public class BinarySearchTree {
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

    public static Node constructor(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;

        int data = arr[mid];
        Node lc = constructor(arr, lo, mid - 1);
        Node rc = constructor(arr, mid + 1, hi);
        Node node = new Node(data, lc, rc);
        return node;
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
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }
    }

    public static int min(Node node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.data;
        }
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data > node.data) {
            return find(node.left, data);
        } else if (data > node.data) {
            return find(node.right, data);
        } else {
            return true;
        }
    }

    public static Node add(Node node, int data) {
        if (node == null) {
            return new Node(data, null, null);
        }
        if (data > node.data) {
            node.right = add(node.right, data);
        } else if (data < node.data) {
            node.left = add(node.left, data);
        }
        return node;
    }

    public static Node remove(Node node, int data) {
        if (node == null) {
            return node;
        }
        if (data > node.data) {
            node.right = remove(node.right, data);
        } else if (node.data < data) {
            node.left = remove(node.left, data);
        } else {
            if (node.left != null && node.right != null) {
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, data);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }

    static int sum = 0;

    public static void rwsol(Node node) {
        if (node == null) {
            return;
        }
        rwsol(node.right);
        int od = node.data;
        node.data = sum;
        sum += od;
        rwsol(node.left);
    }

    public static int lca(Node node, int d1, int d2) {
        if (d1 < node.data && d2 < node.data) {
            return lca(node.left, d1, d2);
        } else if (d1 > node.data && d2 > node.data) {
            return lca(node.right, d1, d2);
        } else {
            return node.data;
        }
    }

    public static void main(String[] args) {

    }
}