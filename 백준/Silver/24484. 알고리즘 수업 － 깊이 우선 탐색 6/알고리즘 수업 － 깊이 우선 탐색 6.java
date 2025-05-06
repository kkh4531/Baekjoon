import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean visit[];
    static ArrayList<ArrayList<Integer>> graph;
    static int res[];
    static int t[];
    static int cnt = 2;
    public static void dfs(int r, int depth) {
        for (int nv : graph.get(r)) {
            if (!visit[nv]) {
                visit[nv] = true;
                res[nv] = depth;
                t[nv] = cnt++;
                dfs(nv, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
        res = new int[n + 1];
        t = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = -1;
        }
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
        visit[r] = true;
        res[r] = 0;
        t[r] = 1;
        dfs(r, 1);
        StringBuilder sb = new StringBuilder();
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += (long) res[i] * t[i];
        }
        System.out.println(result);
    }
}