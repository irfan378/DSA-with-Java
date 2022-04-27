public class Queue {
    public static class customQueue {
        int[] data;
        int front;
        int size;

        public customQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        void add(int val) {
            if (size == data.length) {
                System.out.println("Queue Overflow");
            } else {
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                return data[front];
            }
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int index = (front + 1) % data.length;
                System.out.print(data[index] + " ");
            }
            System.out.println();
        }

        void dynamicAdd(int val) {
            if (size == data.length) {
                int[] ndata = new int[2 * data.length];
                for (int i = 0; i < size; i++) {
                    int index = (front + i) % data.length;
                    ndata[i] = data[index];
                }
                data = ndata;
                front = 0;

                int index = (front + size) % data.length;
                data[index] = val;
                size++;
            } else {
                int index = (front + size) % data.length;
                data[index] = val;
                size++;
            }
        }
    }
}
