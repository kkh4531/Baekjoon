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

    public static void bfs_0_1(int startY, int startX, int targetY, int targetX) {
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[startY][startX] = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[]{startY, startX, 0});
        while (!dq.isEmpty()) {
            int tmp[] = dq.removeFirst();
            int cy = tmp[0];
            int cx = tmp[1];
            int nowCost = tmp[2];
            if (nowCost > dis[cy][cx]) continue;
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 1 && ny <= n && nx >= 1 && nx <= m) {
                    if (ny == targetY && nx == targetX) {
                        dis[targetY][targetX] = dis[cy][cx] + 1;
                        return;
                    }
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

        dis = new int[n + 1][m + 1];
        board = new char[n + 1][m + 1];
        st = new StringTokenizer(bufferedReader.readLine());
        int junanY = Integer.parseInt(st.nextToken());
        int junanX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());
        int targetX = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            String input = bufferedReader.readLine();
            for (int j = 1; j <= m; j++) {
                board[i][j] = input.charAt(j - 1);
            }
        }
        bfs_0_1(junanY, junanX, targetY, targetX);
        System.out.print(dis[targetY][targetX]);
    }
}