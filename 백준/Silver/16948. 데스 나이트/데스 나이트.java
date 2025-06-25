import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static boolean visit[][];
    static int dis[][];
    static int dy[] = {-1, +1, -2, +2, -1, +1};
    static int dx[] = {-2, -2, 0, 0, 2, 2};

    public static void bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        visit[startY][startX] = true;
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 6; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                    dis[ny][nx] = dis[cy][cx] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        visit = new boolean[n][n];
        dis = new int[n][n];

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        bfs(startX, startY, endX, endY);
        System.out.print(visit[endY][endX] ? dis[endY][endX] : -1);
    }
}