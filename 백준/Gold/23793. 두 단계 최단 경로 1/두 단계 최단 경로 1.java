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

    static int dis[];
    static ArrayList<ArrayList<Node>> graph;
    static int v;
    static int Y;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        v = Integer.parseInt(st.nextToken());
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
        }

        st = new StringTokenizer(bufferedReader.readLine());
        int X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        dijkstra(X, true);
        int XtoY = dis[Y];
        dijkstra(Y, true);
        int YtoZ = dis[Z];

        if (XtoY == Integer.MAX_VALUE || YtoZ == Integer.MAX_VALUE) {
            sb.append(-1).append(" ");
        } else {
            sb.append(XtoY + YtoZ).append(" ");
        }

        dijkstra(X, false);
        if (dis[Z] == Integer.MAX_VALUE) {
            sb.append(-1);
        } else {
            sb.append(dis[Z]);
        }
        System.out.print(sb);
    }

    private static void dijkstra(int startVertex, boolean flag) {
        dis = new int[v + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[startVertex] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startVertex, 0));
        if (flag) {
            while (!pq.isEmpty()) {
                Node current = pq.poll();
                if (current.cost > dis[current.vertex]) continue;
                for (Node nv : graph.get(current.vertex)) {
                    if (dis[nv.vertex] > current.cost + nv.cost) {
                        dis[nv.vertex] = current.cost + nv.cost;
                        pq.offer(new Node(nv.vertex, current.cost + nv.cost));
                    }
                }
            }
        } else {
            while (!pq.isEmpty()) {
                Node current = pq.poll();
                if (current.cost > dis[current.vertex]) continue;
                for (Node nv : graph.get(current.vertex)) {
                    if (nv.vertex == Y) continue;
                    if (dis[nv.vertex] > current.cost + nv.cost) {
                        dis[nv.vertex] = current.cost + nv.cost;
                        pq.offer(new Node(nv.vertex, current.cost + nv.cost));
                    }
                }
            }
        }
    }
}