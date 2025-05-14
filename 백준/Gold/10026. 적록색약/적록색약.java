import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static char board[][];
    static boolean visit[][];
    static char present;
    static Queue<int[]> queue;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static void bfs(boolean flag) {
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (flag) {
                    if (present == 'R' || present == 'G') {
                        if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !visit[ny][nx] && (board[ny][nx] == 'R' || board[ny][nx] == 'G')) {
                            visit[ny][nx] = true;
                            queue.offer(new int[]{ny, nx});
                        }
                    } else {
                        if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !visit[ny][nx] && board[ny][nx] == 'B') {
                            visit[ny][nx] = true;
                            queue.offer(new int[]{ny, nx});
                        }
                    }
                } else {
                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !visit[ny][nx] && board[ny][nx] == present) {
                        visit[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        board = new char[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                char tmp = str.charAt(j);
                if (tmp == 'R') board[i][j + 1] = 'R';
                else if (tmp == 'G') board[i][j + 1] = 'G';
                else board[i][j + 1] = 'B';
            }
        }
        queue = new LinkedList<>();
        boolean flag = false;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    present = board[i][j];
                    queue.offer(new int[]{i, j});
                    bfs(flag);
                    cnt++;
                    i = 1;
                    j = 0;
                }
            }
        }
        flag = true;
        int cnt2 = 0;
        visit = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    present = board[i][j];
                    queue.offer(new int[]{i, j});
                    bfs(flag);
                    cnt2++;
                    i = 1;
                    j = 0;
                }
            }
        }
        System.out.println(cnt + " " + cnt2);
    }
}