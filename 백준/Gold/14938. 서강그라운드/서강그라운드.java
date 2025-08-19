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
            return this.cost - o.cost;
        }
    }

    static int dis[];
    static ArrayList<ArrayList<Node>> graph;

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
                    pq.offer(new Node(nv.vertex, nowCost + nv.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int numOfItem[] = new int[n + 1];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            numOfItem[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dis = new int[n + 1];
            Arrays.fill(dis, Integer.MAX_VALUE);
            dijkstra(i);
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dis[j] <= m) {
                    sum += numOfItem[j];
                }
            }
            max = Math.max(max, sum);
        }
        System.out.print(max);
    }

}