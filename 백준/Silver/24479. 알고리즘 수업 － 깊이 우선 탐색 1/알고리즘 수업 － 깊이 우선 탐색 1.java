import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean visit[];
    static int result[];
    static int cnt = 1;
    
    public static void dfs(int v) {
        for (int nv : graph.get(v)) {
            if (!visit[nv]) {
                cnt++;
                result[nv] = cnt;
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
        int r = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        result = new int[n + 1];
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
            Collections.sort(graph.get(i));
        }
        result[r] = 1;
        visit[r] = true;
        dfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }
}