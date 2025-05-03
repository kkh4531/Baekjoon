import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean visit[];
    static int result[];

    public static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        visit[r] = true;
        result[r] = 0;
        queue.offer(r);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv : graph.get(cv)) {
                if (!visit[nv]) {
                    visit[nv] = true;
                    result[nv] = result[cv] + 1;
                    queue.offer(nv);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new boolean[n + 1];
        result = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        bfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                sb.append(-1).append('\n');
            } else {
                sb.append(result[i]).append('\n');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}