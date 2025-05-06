import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean visit[];
    static ArrayList<ArrayList<Integer>> graph;
    static int res[][];

    public static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv : graph.get(cv)) {
                if (!visit[nv]) {
                    visit[nv] = true;
                    res[r][nv] = 1;
                    queue.offer(nv);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        visit = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        res = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            bfs(i);
            visit = new boolean[n + 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}