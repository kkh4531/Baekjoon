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
        String gender[] = new String[n + 1];
        unf = new int[n + 1];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
            gender[i] = st.nextToken();
        }

        ArrayList<Edge> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Edge(v1, v2, cost));
        }
        Collections.sort(list);
        int res = 0;
        for (Edge e : list) {
            int fv1 = find(e.v1);
            int fv2 = find(e.v2);
            if (fv1 != fv2 && !gender[e.v1].equals(gender[e.v2])) {
                union(fv1, fv2);
                res += e.cost;
            }
        }
        boolean flag = false;
        int now = find(1);
        for (int i = 2; i <= n; i++) {
            if (find(i) != now) flag = true;
        }
        System.out.print(flag ? -1 : res);
    }

    private static void union(int a, int b) {
        unf[a] = b;
    }

    private static int find(int v) {
        if (unf[v] == v) return v;
        return unf[v] = find(unf[v]); // 경로 압축
    }
}