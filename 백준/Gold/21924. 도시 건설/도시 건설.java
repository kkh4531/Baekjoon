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

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        unf = new int[m + 1];
        for (int i = 1; i <= m; i++) unf[i] = i;
        ArrayList<Edge> list = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Edge(v1, v2, cost));
            sum += cost;
        }
        Collections.sort(list);
        long sum2 = 0;
        for (Edge e : list) {
            int fv1 = find(e.v1);
            int fv2 = find(e.v2);
            if (fv1 != fv2) {
                union(fv1, fv2);
                sum2 += e.cost;
            }
        }

        for (int i = 1; i <= m; i++) {
            find(i);
        }
        int tmp = unf[1];
        boolean flag = false;
        for (int i = 1; i <= m; i++) {
            if (tmp != find(i)) flag = true;
        }
        
        System.out.print(flag ? -1 : sum - sum2);
    }

    static int unf[];

    private static int find(int v) {
        if (unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    private static void union(int fv1, int fv2) {
        unf[fv1] = fv2;
    }
}