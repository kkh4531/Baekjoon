import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0}; // 12, 3, 6, 9
    static int dy[] = {0, 1, 0, -1}; // 12 3 6 9
    static int board[][];
    static int dis[][];

    public static void bfs(int initX, int initY, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{initX, initY});
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    dis[nx][ny] = dis[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n + 1][m + 1];
        dis = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == '1') {
                    board[i + 1][j + 1] = 1;
                } else {
                    board[i + 1][j + 1] = 0;
                }
            }
        }
        board[1][1] = 0;
        dis[1][1] = 0;
        bfs(1, 1, n, m);
        System.out.println(dis[n][m] + 1);
    }
}