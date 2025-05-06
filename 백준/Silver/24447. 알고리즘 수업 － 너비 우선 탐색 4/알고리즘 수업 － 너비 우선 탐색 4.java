import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean visit[];
    static int dis[];
    static int t[];
    static int n;

    public static long bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        visit[r] = true;
        dis[r] = 0;
        t[r] = 1;
        int cnt = 2;
        queue.offer(r);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv : graph.get(cv)) {
                if (!visit[nv]) {
                    visit[nv] = true;
                    dis[nv] = dis[cv] + 1;
                    t[nv] = cnt++;
                    queue.offer(nv);
                }
            }
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res = res + ((long) dis[i] * t[i]);
        }
        return res;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new boolean[n + 1];
        dis = new int[n + 1];
        t = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
        System.out.println(bfs(r));
    }
}