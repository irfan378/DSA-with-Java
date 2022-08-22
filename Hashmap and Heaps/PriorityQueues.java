import java.util.PriorityQueue;

public class PriorityQueues {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] set = { 1, 243, 45, 24, 43, 5 };
        for (int val : set) {
            pq.add(val);
        }
        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
