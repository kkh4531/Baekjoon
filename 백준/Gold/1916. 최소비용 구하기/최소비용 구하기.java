import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    public int vertex;
    public int cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
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
            int nowVertex = tmp.vertex;
            int nowCost = tmp.cost;
            if (nowCost > dis[nowVertex]) continue;
            for (Node nv : graph.get(nowVertex)) {
                if (dis[nv.vertex] > nowCost + nv.cost) {
                    dis[nv.vertex] = nowCost + nv.cost;
                    pq.offer(new Node(nv.vertex, nowCost + nv.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        dis = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(dis, Integer.MAX_VALUE);
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
        }
        st = new StringTokenizer(bufferedReader.readLine());
        int startVertex = Integer.parseInt(st.nextToken());
        int res = Integer.parseInt(st.nextToken());
        dijikstra(startVertex);
        System.out.println(dis[res]);
    }
}