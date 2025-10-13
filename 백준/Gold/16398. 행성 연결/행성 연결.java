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

        int n = Integer.parseInt(bufferedReader.readLine());
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        ArrayList<Edge> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (i != j) {
                    list.add(new Edge(i, j, tmp));
                }
            }
        }
        Collections.sort(list);
        int cnt = 0;
        long res = 0;
        for (Edge e : list) {
            int fv1 = find(e.v1);
            int fv2 = find(e.v2);
            if (fv1 != fv2) {
                union(fv1, fv2);
                cnt++;
                res += e.cost;
            }
            if (cnt == n - 1) break;
        }

        System.out.print(res);
    }

    private static void union(int fv1, int fv2) {
        unf[fv1] = fv2;
    }

    private static int find(int v) {
        if (unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

}