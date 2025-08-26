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
    static int parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[n + 1];
        parent = new int[n + 1];
        int m = Integer.parseInt(bufferedReader.readLine());
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
        int endVertex = Integer.parseInt(st.nextToken());
        Arrays.fill(dis, Integer.MAX_VALUE);
        dijkstra(startVertex);
        StringBuilder sb = new StringBuilder();
        sb.append(dis[endVertex]).append('\n');
        int cnt = 1;
        int idx = endVertex;
        while (idx != startVertex) {
            cnt++;
            idx = parent[idx];
        }
        sb.append(cnt).append('\n');
        idx = endVertex;
        Deque<Integer> dq = new ArrayDeque<>();
        while (idx != startVertex) {
            dq.addFirst(idx);
            idx = parent[idx];
        }
        dq.addFirst(idx);
        for (int i : dq) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int startVertex) {
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
                    parent[nv.vertex] = nowVertex;
                    pq.offer(new Node(nv.vertex, nowCost + nv.cost));
                }
            }
        }
    }

}