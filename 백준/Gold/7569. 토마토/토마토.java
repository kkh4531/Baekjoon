import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int h;
    static int board[][][];
    static int dis[][][];
    static int dx[] = {0, 1, 0, -1, 0, 0};
    static int dy[] = {-1, 0, 1, 0, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};

    public static void bfs(Queue<int[]> initQueue) {
        Queue<int[]> queue = new LinkedList<>();
        int size = initQueue.size();
        for (int i = 0; i < size; i++) {
            queue.offer(initQueue.poll());
        }
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cz = tmp[0];
            int cy = tmp[1]; // 행 -> y
            int cx = tmp[2]; // 열 -> x
            for (int i = 0; i < 6; i++) {
                int nx = cx + dx[i]; // 열
                int ny = cy + dy[i]; // 행
                int nz = cz + dz[i];
                if (nx >= 1 && nx <= m && ny >= 1 && ny <= n && nz >= 1 && nz <= h && board[nz][ny][nx] == 0) {
                    board[nz][ny][nx] = 1;
                    queue.offer(new int[]{nz, ny, nx});
                    dis[nz][ny][nx] = dis[cz][cy][cx] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        board = new int[h + 1][n + 1][m + 1];
        dis = new int[h + 1][n + 1][m + 1];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(bufferedReader.readLine());
                for (int k = 1; k <= m; k++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp == 1) {
                        board[i][j][k] = 1;
                        queue.offer(new int[]{i, j, k});
                    } else if (tmp == -1) {
                        board[i][j][k] = -1;
                    }
                }
            }
        }
        bfs(queue);
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (board[i][j][k] == 0) {
                        flag = true;
                    }
                    max = Math.max(max, dis[i][j][k]);
                }
            }
        }
        if (flag) {
            sb.append(-1);
        } else {
            if (max == 0) sb.append(0);
            else sb.append(max);
        }
        System.out.println(sb);
    }
}