import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean visit[];
    static ArrayList<ArrayList<int[]>> graph;
    static boolean flag;
    static int sum;
    public static void dfs(int startVertex, int endVertex, int distance) {
        if (startVertex == endVertex) {
            sum = distance;
            flag = true;
        } else {
            ArrayList<int[]> tmp = graph.get(startVertex);
            for (int nv[] : tmp) {
                if (!visit[nv[0]] && !flag) {
                    visit[nv[0]] = true;
                    dfs(nv[0], endVertex, distance + nv[1]);
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
            visit[startVertex] = true;
            flag = false;
            dfs(startVertex, endVertex, 0);
            sb.append(sum).append('\n');
            visit = new boolean[n + 1];
            sum = 0;
        }
        System.out.println(sb);
    }
}