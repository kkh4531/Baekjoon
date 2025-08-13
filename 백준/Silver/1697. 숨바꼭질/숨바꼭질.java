import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean visit[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        if (n == k) {
            System.out.println(0);
            return;
        }
        System.out.println(bfs(n, k));
    }

    private static int bfs(int n, int k) {
        int max = 100000;
        Queue<Integer> queue = new LinkedList<>();
        visit[n] = true;
        queue.offer(n);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                int cTimes = current * 2;
                int cUp = current + 1;
                int cDown = current - 1;
                if (cTimes <= max && cTimes >= 0 && !visit[cTimes]) {
                    if (cTimes == k) return level + 1;
                    visit[cTimes] = true;
                    queue.offer(cTimes);
                }
                if (cUp <= max && cUp >= 0 && !visit[cUp]) {
                    if (cUp == k) return level + 1;
                    visit[cUp] = true;
                    queue.offer(cUp);
                }
                if (cDown <= max && cDown >= 0 && !visit[cDown]) {
                    if (cDown == k) return level + 1;
                    visit[cDown] = true;
                    queue.offer(cDown);
                }
            }
            level++;
        }
        return 0;
    }
}