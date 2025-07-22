import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean visit[][];
    static char board[][];
    //    static int n; // ㅅㅔ로
//    static int m; // 가로
    static int dyGaro[] = {0, 0}; // 12, 6
    static int dxGaro[] = {-1, 1};
    static int dySero[] = {-1, 1};
    static int dxSero[] = {0, 0}; // 9, 3

    public static void bfs(int n, int m, int y, int x, boolean flag) {
        visit[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            if (flag) { // 가로
                for (int i = 0; i < 2; i++) {
                    int ny = cy + dyGaro[i];
                    int nx = cx + dxGaro[i];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visit[ny][nx] && board[ny][nx] == '-') {
                        visit[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    int ny = cy + dySero[i];
                    int nx = cx + dxSero[i];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visit[ny][nx] && board[ny][nx] == '|') {
                        visit[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visit = new boolean[n][m];
        board = new char[n][m];

        Queue<int[]> queueSero = new LinkedList<>();
        Queue<int[]> queueGaro = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String tmp = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp.charAt(j);
                if (tmp.charAt(j) == '|') queueSero.offer(new int[]{i, j});
                else queueGaro.offer(new int[]{i, j});
            }
        }
        int size = queueGaro.size();
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            int tmp[] = queueGaro.poll();
            int y = tmp[0];
            int x = tmp[1];
            if (!visit[y][x]) {
                bfs(n, m, y, x, true);
                cnt++;
            }
        }
        size = queueSero.size();
        for (int i = 0; i < size; i++) {
            int tmp[] = queueSero.poll();
            int y = tmp[0];
            int x = tmp[1];
            if (!visit[y][x]) {
                bfs(n, m, y, x, false);
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}