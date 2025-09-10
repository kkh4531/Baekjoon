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
    static int res[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dis = new int[v];
            res = new int[v];
            graph = new ArrayList<>();
            for (int j = 0; j < v; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(bufferedReader.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph.get(from).add(new Node(to, cost));
                graph.get(to).add(new Node(from, cost));
            }

            dijkstra();
            if (res[v - 1] == -1) {
                sb.append("Case").append(" #").append(i).append(": ").append(-1).append('\n');
            } else {
                Deque<Integer> dq = new ArrayDeque<>();
                int idx = v - 1;
                while (true) {
                    dq.addFirst(idx);
                    idx = res[idx];
                    if (idx == 0) {
                        dq.addFirst(0);
                        break;
                    }
                }
                sb.append("Case").append(" #").append(i).append(": ");
                int size = dq.size();
                for (int j = 0; j < size; j++) {
                    sb.append(dq.pollFirst()).append(" ");
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    private static void dijkstra() {
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(res, -1);
        dis[0] = 0;
        res[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int nowVertex = current.vertex;
            int nowCost = current.cost;
            if (nowCost > dis[nowVertex]) continue;
            for (Node nv : graph.get(nowVertex)) {
                if (dis[nv.vertex] > nowCost + nv.cost) {
                    dis[nv.vertex] = nowCost + nv.cost;
                    res[nv.vertex] = nowVertex;
                    pq.offer(new Node(nv.vertex, nowCost + nv.cost));
                }
            }
        }
    }
}