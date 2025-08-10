import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int dis[][];
    static char board[][];
    static int n;
    static int m;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static void bfs_0_1() {
        for (int i = 1; i <= m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[1][1] = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[]{1, 1, 0});
        while (!dq.isEmpty()) {
            int tmp[] = dq.removeFirst();
            int cy = tmp[0];
            int cx = tmp[1];
            int nowCost = tmp[2];
            if (nowCost > dis[cy][cx]) continue;
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 1 && ny <= m && nx >= 1 && nx <= n) {
                    if (board[ny][nx] == '1') {
                        if (dis[ny][nx] > dis[cy][cx] + 1) {
                            dis[ny][nx] = dis[cy][cx] + 1;
                            dq.addLast(new int[]{ny, nx, nowCost + 1});
                        }
                    } else {
                        if (dis[ny][nx] > dis[cy][cx]) {
                            dis[ny][nx] = dis[cy][cx];
                            dq.addFirst(new int[]{ny, nx, nowCost});
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dis = new int[m + 1][n + 1];
        board = new char[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            String input = bufferedReader.readLine();
            for (int j = 1; j <= n; j++) {
                board[i][j] = input.charAt(j - 1);
            }
        }
        bfs_0_1();
        System.out.println(dis[m][n]);
    }
}