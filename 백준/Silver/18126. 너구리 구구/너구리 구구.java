import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<int[]>> graph;
    static long max = Integer.MIN_VALUE;
    static boolean visit[];

    public static void dfs(int cv, long sum) {
        boolean flag = false;
        for (int[] tmp : graph.get(cv)) {
            int nv = tmp[0];
            int value = tmp[1];
            if (!visit[nv]) {
                flag = true;
                visit[nv] = true;
                dfs(nv, sum + value);
                visit[nv] = false;
            }
        }
        if (!flag) {
            max = Math.max(max, sum);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        graph = new ArrayList<>();
        visit = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }
        visit[1] = true;
        dfs(1, 0);

        System.out.print(max);
    }
}