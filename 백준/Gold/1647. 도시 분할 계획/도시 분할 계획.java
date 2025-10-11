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
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        if (v == 2) {
            System.out.print(0);
            return;
        }
        unf = new int[v + 1];
        for (int i = 1; i <= v; i++) unf[i] = i;
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(v1, v2, cost));
        }

        Collections.sort(edges);

        long res = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            int fv1 = find(edge.v1);
            int fv2 = find(edge.v2);
            if (fv1 != fv2) {
                Union(fv1, fv2);
                res += edge.cost;
                cnt++;
            }
            if (cnt == v - 2) break;
        }
        System.out.print(res);
    }

    private static void Union(int fv1, int fv2) {
        unf[fv1] = fv2;
    }

    private static int find(int v) {
        if (unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }
}