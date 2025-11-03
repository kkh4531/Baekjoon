import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Edge implements Comparable<Edge> {

        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int unf[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;

        ArrayList<Edge> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Edge(v1, v2, cost));
        }

        Collections.sort(list);

        int totalCost = 0;
        int edgesConnected = 0;

        for (Edge e : list) {
            int rootV1 = find(e.v1);
            int rootV2 = find(e.v2);
            if (rootV1 != rootV2) {
                union(rootV1, rootV2);
                totalCost += e.cost + (edgesConnected * t); 
                edgesConnected++;

                if (edgesConnected == n - 1) {
                    break;
                }
            }
        }
        System.out.print(totalCost);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            unf[b] = a;
        }
    }

    private static int find(int v) {
        if (unf[v] == v) return v;
        return unf[v] = find(unf[v]);
    }
}