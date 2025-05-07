import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int board[][];
    static int dis[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};

    public static void bfs(Queue<int[]> initQueue) {
        Queue<int[]> queue = new LinkedList<>();
        int size = initQueue.size();
        for (int i = 0; i < size; i++) {
            queue.offer(initQueue.poll());
        }
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0]; // 행 -> y
            int cx = tmp[1]; // 열 -> x
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; // 열
                int ny = cy + dy[i]; // 행
                if (nx >= 1 && nx <= m && ny >= 1 && ny <= n && board[ny][nx] == 0) {
                    board[ny][nx] = 1;
                    queue.offer(new int[]{ny, nx});
                    dis[ny][nx] = dis[cy][cx] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n + 1][m + 1];
        dis = new int[n + 1][m + 1];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) {
                    board[i][j] = -1;
                } else if (tmp == 1) {
                    board[i][j] = 1;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        bfs(queue);
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 0) {
                    flag = true;
                }
                max = Math.max(max, dis[i][j]);
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