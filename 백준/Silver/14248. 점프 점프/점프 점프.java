import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
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

        n = Integer.parseInt(bufferedReader.readLine());
        visit = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (i - tmp > 0) graph.get(i).add(i - tmp); // 왼쪽 노드
            if (i + tmp <= n) graph.get(i).add(i + tmp); // 오른쪽 노드
        }
        int s = Integer.parseInt(bufferedReader.readLine());
        visit[s] = true;
        dfs(s);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visit[i]) cnt++;
        }
        System.out.print(cnt);
    }
}