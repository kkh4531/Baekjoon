import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean visit[];

    public static int bfs(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visit[start] = true;
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cv = tmp[0];
            int num = tmp[1];
            for (int nv : graph.get(cv)) {
                if (!visit[nv]) {
                    if (nv == target) {
                        return num + 1;
                    }
                    visit[nv] = true;
                    queue.offer(new int[]{nv, num + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(bufferedReader.readLine());
        visit = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        System.out.print(bfs(start, target));
    }
}