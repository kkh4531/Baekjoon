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

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        dis = new int[v];
        graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
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
        dijkstra(y);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (i == y) continue;
            int tmp = dis[i];
            if (tmp * 2 > x) {
                System.out.println(-1);
                return;
            }
            if (tmp == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }
            list.add(tmp);
        }
        Collections.sort(list);
        int sum = 0;
        int cnt = 0;
        for (int i : list) {
            sum += i * 2;
            if (sum > x) {
                cnt++;
                sum = i * 2;
            }
        }
        cnt++;
        System.out.print(cnt);
    }

    private static void dijkstra(int startVertex) {
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
    }

}