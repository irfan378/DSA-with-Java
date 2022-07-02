import java.util.ArrayList;

public class Graphs {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int vces = 7;
        ArrayList<Edge>[] graph = new ArrayList[vces];
        for (int i = 0; i < vces; i++) {
            graph[i] = new ArrayList<>();
        }
    }
}