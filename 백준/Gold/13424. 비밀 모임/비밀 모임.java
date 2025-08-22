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
    static int dis[][];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(bufferedReader.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
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

            int k = Integer.parseInt(bufferedReader.readLine());
            st = new StringTokenizer(bufferedReader.readLine());
            int arr[] = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dis = new int[k + 1][v + 1];
            for (int i = 1; i <= k; i++) {
                Arrays.fill(dis[i], Integer.MAX_VALUE);
                dijkstra(i, arr[i]);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= v; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += dis[j][i];
                }
                min = Math.min(min, sum);
            }
            for (int i = 1; i <= v; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += dis[j][i];
                }
                if (sum == min) {
                    pq.offer(i);
                }
            }
            sb.append(pq.poll()).append('\n');
        }
        System.out.print(sb);
    }

    private static void dijkstra(int i, int startVertex) {
        dis[i][startVertex] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startVertex, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int nowVertex = current.vertex;
            int nowCost = current.cost;
            if (nowCost > dis[i][nowVertex]) continue;
            for (Node nv : graph.get(nowVertex)) {
                if (dis[i][nv.vertex] > nowCost + nv.cost) {
                    dis[i][nv.vertex] = nowCost + nv.cost;
                    pq.offer(new Node(nv.vertex, nowCost + nv.cost));
                }
            }
        }
    }

}