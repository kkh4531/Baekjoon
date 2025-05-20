import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static boolean visit[];
    static int res[];
    static ArrayList<ArrayList<Integer>> graph;

    public static void dfs(int cv) {
        for (int nv : graph.get(cv)) {
            if (!visit[nv]) {
                visit[nv] = true;
                res[nv] = cv;
                dfs(nv);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        visit = new boolean[n + 1];
        graph = new ArrayList<>();
        res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        visit[1] = true;
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < res.length; i++) {
            sb.append(res[i]).append('\n');
        }
        System.out.println(sb);
    }
}