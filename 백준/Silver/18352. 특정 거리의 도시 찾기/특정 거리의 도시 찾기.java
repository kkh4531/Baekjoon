import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static boolean visit[];
    static int dis[];
    static ArrayList<ArrayList<Integer>> graph;

    public static void bfs(int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        visit[k] = true;
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int nv : graph.get(cv)) {
                if (!visit[nv]) {
                    visit[nv] = true;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
        dis = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }
        bfs(x);
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == k) {
                sb.append(i).append('\n');
                flag = true;
            }
        }
        if (!flag) {
            sb.append(-1).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}