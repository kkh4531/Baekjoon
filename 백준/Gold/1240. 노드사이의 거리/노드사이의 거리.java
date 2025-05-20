import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean visit[];
    static ArrayList<ArrayList<int[]>> graph;
    static int res[];

    public static void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visit[startVertex] = true;
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int[] nv : graph.get(cv)) {
                if (!visit[nv[0]]) {
                    visit[nv[0]] = true;
                    res[nv[0]] = res[cv] + nv[1];
                    queue.offer(nv[0]);
                }
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
        res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph.get(from).add(new int[]{to, value});
            graph.get(to).add(new int[]{from, value});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int startVertex = Integer.parseInt(st.nextToken());
            int endVertex = Integer.parseInt(st.nextToken());
            bfs(startVertex);
            sb.append(res[endVertex]).append('\n');
            visit = new boolean[n + 1];
            res = new int[n + 1];
        }
        System.out.println(sb);
    }
}