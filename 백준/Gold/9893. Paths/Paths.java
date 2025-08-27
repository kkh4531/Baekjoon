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

        dis = new int[v + 1];
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

        dijkstra();
        System.out.println(dis[1]);
    }

    private static void dijkstra() {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        boolean flag= false;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                int nowVertex = current.vertex;
                int nowCost = current.cost;
                for (Node nv : graph.get(nowVertex)) {
                    if (nv.vertex == 1) {
                        flag = true;
                        if (dis[1] > nowCost + nv.cost) {
                            dis[1] = nowCost + nv.cost;
                        }
                    } else {
                        q.offer(new Node(nv.vertex, nowCost + nv.cost));
                    }
                }
            }
            if (flag) {
                return;
            }
        }
    }

}