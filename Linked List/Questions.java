public class Questions {

    public static class LL {
        private Node head;
        private Node tail;
        private int size;

        public LL() {
            this.size = 0;
        }

        public void insertFirst(int val) {
            Node node = new Node(val);
            node.next = head;
            head = node;

            if (tail == null) {
                tail = head;
            }
            size += 1;
        }

        public void insertLast(int val) {
            if (tail == null) {
                insertFirst(val);
                return;
            }

            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;

        }

        public void insert(int val, int index) {
            if (index == 0) {
                insertFirst(val);
                return;
            }
            if (index == size) {
                insertLast(val);
                return;
            }
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node node = new Node(val, temp.next);
            temp.next = node;

            size++;
        }

        public int deleteFirst() {
            int val = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return val;
        }

        // insert using recursion
        public void insertRec(int val, int index) {
            head = insertRec(val, index, head);
        }

        private Node insertRec(int val, int index, Node node) {
            if (index == 0) {
                Node temp = new Node(val, node);
                size++;
                return temp;
            }
            node.next = insertRec(val, index--, node.next);
            return node;
        }

        public int deleteLast() {
            if (size <= 1) {
                return deleteFirst();
            }
            int val = tail.value;
            Node secondLast = get(size - 2);
            tail = secondLast;
            tail.next = null;
            return val;
        }

        public int delete(int index) {
            if (index == 0) {
                return deleteFirst();
            }
            if (index == size - 1) {
                return deleteLast();
            }
            Node prev = get(index - 1);
            int val = prev.next.value;

            prev.next = prev.next.next;

            return val;
        }

        public Node get(int index) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        public Node find(int value) {
            Node node = head;
            while (node != null) {
                if (node.value == value) {
                    return node;
                }
                node = node.next;
            }
            return null;
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }

        private class Node {
            private int value;
            private Node next;

            public Node(int value) {
                this.value = value;
            }

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }

        public void duplicates() {
            Node node = head;
            while (node.next != null) {
                if (node.value == node.next.value) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            tail = node;
            tail.next = null;
        }

        // merge
        public static LL merge(LL first, LL second) {
            Node f = first.head;
            Node s = second.head;

            LL ans = new LL();
            while (f != null && s != null) {
                if (f.value < s.value) {
                    ans.insertLast(f.value);
                    f = f.next;
                } else {
                    ans.insertLast(s.value);
                    s = s.next;
                }
            }
            while (f != null) {
                ans.insertLast(f.value);
                f = f.next;
            }
            while (s != null) {
                ans.insertLast(s.value);
                s = s.next;
            }
            return ans;

        }

        // has cycle
        public boolean hasCycle() {
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }

        // Length of cycle
        public int lengthOfCycle(Node head) {
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    // calculate the length
                    Node temp = slow;
                    int length = 0;
                    do {
                        temp = temp.next;
                        length++;
                    } while (temp != slow);
                    return length;
                }
            }
            return 0;
        }

        // detect Cycle
        public Node detectCycle(Node head) {
            int length = 0;
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    length = lengthOfCycle(slow);
                    break;
                }
            }
            if (length == 0) {
                return null;
            }
            // find the start node
            Node f = head;
            Node s = head;
            while (length > 0) {
                s = s.next;
                length--;
            }
            // Keep moving both forward and they will meet at cycle start.
            while (f != s) {
                f = f.next;
                s = s.next;
            }
            return s;
        }

        public boolean isHappy(int n) {
            int slow = n;
            int fast = n;

            do {
                slow = findSquare(slow);
                fast = findSquare(fast);

            } while (fast != slow);
            if (slow == 1) {
                return true;
            }
            return false;
        }

        private int findSquare(int number) {
            int ans = 0;
            while (number > 0) {
                int rem = number % 10;
                ans += rem * rem;
                number = number / 10;
            }
            return ans;
        }

        public Node middle(Node head) {
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public void bubbleSort() {
            bubbleSort(size - 1, 0);
        }

        private void bubbleSort(int row, int col) {
            if (row == 0) {
                return;
            }
            if (col < row) {
                Node first = get(col);
                Node second = get(col + 1);

                if (first.value > second.value) {
                    // swap
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
                bubbleSort(row, col + 1);
            } else {
                bubbleSort(row - 1, 0);
            }
        }

    }

    public static void main(String[] args) {
        // LL list = new LL();
        // list.insertLast(1);
        // list.insertLast(1);
        // list.insertLast(2);
        // list.insertLast(2);
        // list.insertLast(2);
        // list.insertLast(3);
        // list.insertLast(4);

        // list.duplicates();
        // list.display();

        // LL first = new LL();
        // LL second = new LL();

        // first.insertLast(1);
        // first.insertLast(3);
        // first.insertLast(5);

        // second.insertLast(1);
        // second.insertLast(2);
        // second.insertLast(9);
        // second.insertLast(14);

        // LL ans = LL.merge(first, second);
        // ans.display();

    }

}
