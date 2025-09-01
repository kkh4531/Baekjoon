import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;
        int firstVertex;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public void setFirstVertex(int firstVertex) {
            this.firstVertex = firstVertex;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int dis[];
    static int res[][];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dis = new int[v + 1];
        graph = new ArrayList<>();
        res = new int[v + 1][v + 1];
        for (int i = 0; i <= v; i++) {
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
        for (int i = 1; i <= v; i++) {
            dis = new int[v + 1];
            dijkstra(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (j == i) sb.append("-").append(" ");
                else {
                    sb.append(res[i][j]).append(" ");
                }
            }
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void dijkstra(int startVertex) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[startVertex] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Node nv : graph.get(startVertex)) {
            dis[nv.vertex] = nv.cost;
            res[startVertex][nv.vertex] = nv.vertex;
            Node tmp = new Node(nv.vertex, nv.cost);
            tmp.setFirstVertex(nv.vertex);
            pq.offer(tmp);
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int nowVertex = current.vertex;
            int nowCost = current.cost;
            int firstVertex = current.firstVertex;
            if (nowCost > dis[nowVertex]) continue;
            for (Node nv : graph.get(nowVertex)) {
                if (dis[nv.vertex] > nowCost + nv.cost) {
                    dis[nv.vertex] = nowCost + nv.cost;
                    Node tmp = new Node(nv.vertex, nowCost + nv.cost);
                    tmp.setFirstVertex(firstVertex);
                    pq.offer(tmp);
                    res[startVertex][nv.vertex] = firstVertex;
                }
            }
        }
    }

}