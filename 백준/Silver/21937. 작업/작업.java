import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static boolean possible[];
    static ArrayList<ArrayList<Integer>> graph;
    static int x;
    static boolean visit[];
    static int cnt;

    public static void dfs(int cv) {
        for (int nv : graph.get(cv)) {
            if (!visit[nv]) {
                cnt++;
                visit[nv] = true;
                dfs(nv);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        possible = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(to).add(from);
        }
        x = Integer.parseInt(bufferedReader.readLine());
        visit[x] = true;
        dfs(x);
        System.out.print(cnt);
    }
}