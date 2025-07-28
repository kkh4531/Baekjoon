import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class Node implements Comparable<Node> {
    int vertext;
    int cost;

    Node(int vertext, int cost) {
        this.vertext = vertext;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {

    static ArrayList<ArrayList<Node>> graph;
    static int dis[];

    public static void dijikstra(int startVertex) {
        dis[startVertex] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startVertex, 0));
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int currentVertex = tmp.vertext;
            int currentCost = tmp.cost;
            if (currentCost > dis[currentVertex]) continue;
            for (Node nextNode : graph.get(currentVertex)) {
                if (dis[nextNode.vertext] > currentCost + nextNode.cost) {
                    dis[nextNode.vertext] = currentCost + nextNode.cost;
                    pq.offer(new Node(nextNode.vertext, currentCost + nextNode.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dis = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int startVertex = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
        }
        Arrays.fill(dis, Integer.MAX_VALUE);
        dijikstra(startVertex);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append((dis[i] == Integer.MAX_VALUE) ? "INF" : dis[i]).append('\n');
        }
        System.out.print(sb);
    }
}