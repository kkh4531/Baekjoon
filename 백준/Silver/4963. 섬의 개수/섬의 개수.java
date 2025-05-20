import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int y;
    static int x;
    static boolean visit[][];
    static int board[][];
    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void bfs(int height, int width) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{height, width});
        visit[height][width] = true;
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 8; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 1 && ny <= y && nx >= 1 && nx <= x && !visit[ny][nx] && board[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (y == 0 && x == 0) {
                break;
            }
            visit = new boolean[y + 1][x + 1];
            board = new int[y + 1][x + 1];
            Queue<int[]> list = new LinkedList<>();
            for (int i = 1; i <= y; i++) {
                st = new StringTokenizer(bufferedReader.readLine());
                for (int j = 1; j <= x; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    board[i][j] = tmp;
                    if (board[i][j] == 1) {
                        list.add(new int[]{i, j});
                    }
                }
            }
            int cnt = 0;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int tmp[] = list.poll();
                int y = tmp[0];
                int x = tmp[1];
                if (!visit[y][x]) {
                    bfs(y, x);
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}