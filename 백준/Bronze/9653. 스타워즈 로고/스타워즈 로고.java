import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int dis[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("    8888888888  888    88888");
        System.out.println("   88     88   88 88   88  88");
        System.out.println("    8888  88  88   88  88888");
        System.out.println("       88 88 888888888 88   88");
        System.out.println("88888888  88 88     88 88    888888");
        System.out.println(""); // 한 줄 비움
        System.out.println("88  88  88   888    88888    888888");
        System.out.println("88  88  88  88 88   88  88  88");
        System.out.println("88 8888 88 88   88  88888    8888");
        System.out.println(" 888  888 888888888 88  88      88");
        System.out.println("  88  88  88     88 88   88888888");
    }

    private static int dijkstra(int startVertex, int endVertex) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[startVertex] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startVertex, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int nowVertex = current.vertex;
            int nowCost = current.cost;
            if (nowCost > dis[nowVertex]) continue;
            for (Node nv : graph.get(nowVertex)) {
                if (dis[nv.vertex] > nowCost + nv.cost) {
                    dis[nv.vertex] = nowCost + nv.cost;
                    pq.offer(new Node(nv.vertex, nowCost + nv.cost));
                }
            }
        }

        return dis[endVertex];
    }

}