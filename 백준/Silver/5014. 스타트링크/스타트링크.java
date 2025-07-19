import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean visit[];
    static int dis[];
    static int maxFloor;

    public static void bfs(int current, int target, int[] next) {
        visit[current] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(current);
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 0; i < 2; i++) {
                int nv = tmp + next[i];
                if (nv <= maxFloor && nv > 0 && !visit[nv]) {
                    if (nv == target) {
                        dis[target] = dis[tmp] + 1;
                        visit[target] = true;
                        return;
                    }
                    dis[nv] = dis[tmp] + 1;
                    visit[nv] = true;
                    queue.offer(nv);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        maxFloor = Integer.parseInt(st.nextToken());
        visit = new boolean[maxFloor + 1];
        dis = new int[maxFloor + 1];
        int current = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int next[] = {up, -down};

        bfs(current, target, next);

        StringBuilder sb = new StringBuilder();
        if (visit[target]) {
            sb.append(dis[target]);
        } else {
            sb.append("use the stairs");
        }
        System.out.print(sb);
    }
}