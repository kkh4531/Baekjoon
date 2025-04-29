import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean visit[];
    static ArrayList<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visit[v] = true;
        sb.append(v).append(" ");
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv : graph.get(cv)) {
                if (!visit[nv]) {
                    visit[nv] = true;
                    sb.append(nv).append(" ");
                    queue.offer(nv);
                }
            }
        }
    }

    public static void dfs(int v) {
        for (int nv : graph.get(v)) {
            if (!visit[nv]) {
                visit[nv] = true;
                sb.append(nv).append(" ");
                dfs(nv);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
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
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
        visit[v] = true;
        sb.append(v).append(" ");
        dfs(v);
        sb.append('\n');
        visit = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }
}