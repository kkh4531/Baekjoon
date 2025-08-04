import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Node implements Comparable<Node> {
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

    static ArrayList<ArrayList<Node>> graph;
    static int dis[];
    static final int MAX = 200000000;

    public static int dijikstra(int startVertex, int endVertex) {
        Arrays.fill(dis, MAX);
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
        return dis[endVertex];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dis = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }
        st = new StringTokenizer(bufferedReader.readLine());
        int v = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());

        int firstWay = 0;
        firstWay += dijikstra(1, v);
        firstWay += dijikstra(v, u);
        firstWay += dijikstra(u, n);

        int secondWay = 0;
        secondWay += dijikstra(1, u);
        secondWay += dijikstra(u, v);
        secondWay += dijikstra(v, n);
        StringBuilder sb = new StringBuilder();
        if (firstWay >= MAX && secondWay >= MAX) sb.append(-1);
        else sb.append(Math.min(firstWay, secondWay));
        System.out.print(sb);
    }
}