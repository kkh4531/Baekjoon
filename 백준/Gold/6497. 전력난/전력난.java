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


        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(bufferedReader.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;
            unf = new int[m];
            for (int i = 0; i < m; i++) unf[i] = i;
            ArrayList<Edge> list = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bufferedReader.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list.add(new Edge(v1, v2, cost));
                sum += cost;
            }
            Collections.sort(list);
            int sum2 = 0;
            for (Edge e : list) {
                int fv1 = find(e.v1);
                int fv2 = find(e.v2);
                if (fv1 != fv2) {
                    union(fv1, fv2);
                    sum2 += e.cost;
                }
            }
            sb.append(sum - sum2).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
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