import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int z;
    static int y;
    static int x;
    static boolean visit[][][];
    static char board[][][];
    static int dis[][][];
    static int dz[] = {0, 0, 0, 0, 1, -1};
    static int dy[] = {-1, 0, 1, 0, 0, 0};
    static int dx[] = {0, 1, 0, -1, 0, 0};

    public static void bfs(int initZ, int initY, int initX, int tz, int ty, int tx) {
        Queue<int[]> queue = new LinkedList<>();
        visit[initZ][initY][initX] = true;
        queue.offer(new int[]{initZ, initY, initX});
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cz = tmp[0];
            int cy = tmp[1];
            int cx = tmp[2];
            for (int i = 0; i < 6; i++) {
                int nz = cz + dz[i];
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (nz >= 0 && nz < z && ny >= 0 && ny < y && nx >= 0 && nx < x && board[nz][ny][nx] == 'E') {
                    dis[nz][ny][nx] = dis[cz][cy][cx] + 1;
                    visit[nz][ny][nx] = true;
                    return;
                }
                if (nz >= 0 && nz < z && ny >= 0 && ny < y && nx >= 0 && nx < x && !visit[nz][ny][nx] && board[nz][ny][nx] == '.') {
                    visit[nz][ny][nx] = true;
                    queue.offer(new int[]{nz, ny, nx});
                    dis[nz][ny][nx] = dis[cz][cy][cx] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(bufferedReader.readLine());
            z = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            if (z == 0 && y == 0 && x == 0) break;

            visit = new boolean[z][y][x];
            board = new char[z][y][x];
            dis = new int[z][y][x];

            int startZ = 0;
            int startY = 0;
            int startX = 0;

            int tz = 0;
            int ty = 0;
            int tx = 0;

            for (int i = 0; i < z; i++) {
                for (int j = 0; j < y; j++) {
                    String input = bufferedReader.readLine();
                    for (int k = 0; k < x; k++) {
                        char tmp = input.charAt(k);
                        if (tmp == 'S') {
                            startZ = i;
                            startY = j;
                            startX = k;
                        } else if (tmp == 'E') {
                            tz = i;
                            ty = j;
                            tx = k;
                        }
                        board[i][j][k] = tmp;
                    }
                }
                bufferedReader.readLine();
            }

            bfs(startZ, startY, startX, tz, ty, tx);
            if (!visit[tz][ty][tx]) {
                sb.append("Trapped!");
            } else {
                sb.append("Escaped in ").append(dis[tz][ty][tx]).append(" minute(s).");
            }
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}