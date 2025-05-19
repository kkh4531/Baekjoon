import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static boolean visit[];
    static ArrayList<ArrayList<Integer>> graph;

    public static void dfs(int cv) {
        for (int nv : graph.get(cv)) {
            if (!visit[nv]) {
                visit[nv] = true;
                dfs(nv);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
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
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}