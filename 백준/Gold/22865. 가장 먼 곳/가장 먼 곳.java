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
    static int friends[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        friends = new int[3];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 3; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        int disA[] = dijkstra(friends[0], n);
        int disB[] = dijkstra(friends[1], n);
        int disC[] = dijkstra(friends[2], n);

        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int min = Math.min(disA[i], Math.min(disB[i], disC[i]));
            if (min > max) {
                max = min;
                res = i;
            }
        }

        System.out.print(res);
    }

    private static int[] dijkstra(int startVertex, int n) {
        int dis[] = new int[n + 1];
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
        return dis;
    }

}