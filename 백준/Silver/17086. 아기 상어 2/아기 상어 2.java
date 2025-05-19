import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int board[][];
    static int dis[][];
    static boolean visit[][];
    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visit[y][x] = true;
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 8; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (nx >= 1 && nx <= m && ny >= 1 && ny <= n && !visit[ny][nx] && board[ny][nx] == 0) {
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                    if (dis[ny][nx] == 0) dis[ny][nx] = dis[cy][cx] + 1;
                    else dis[ny][nx] = Math.min(dis[ny][nx], dis[cy][cx] + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];
        dis = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 1) {
                    bfs(i, j);
                    visit = new boolean[n + 1][m + 1];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dis[i][j] != 0) {
                    max = Math.max(max, dis[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}