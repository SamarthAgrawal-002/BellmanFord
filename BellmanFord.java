import java.util.*;

public class BellmanFord {

    static class Edge {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    public static void main(String[] args) {

        int V = 5;
        int E = 8;

        Edge[] edges = new Edge[E];

        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);

        bellmanFord(V, edges, 0);
    }

    static void bellmanFord(int V, Edge[] edges, int source) {

        int[] distance = new int[V];

        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        for (int i = 1; i <= V - 1; i++) {
            for (Edge e : edges) {
                if (distance[e.src] != Integer.MAX_VALUE &&
                    distance[e.src] + e.weight < distance[e.dest]) {

                    distance[e.dest] = distance[e.src] + e.weight;
                }
            }
        }

        for (Edge e : edges) {
            if (distance[e.src] != Integer.MAX_VALUE &&
                distance[e.src] + e.weight < distance[e.dest]) {

                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }

        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + distance[i]);
        }
    }
}
