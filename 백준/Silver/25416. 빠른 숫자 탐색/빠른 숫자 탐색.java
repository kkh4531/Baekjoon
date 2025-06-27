import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int board[][];
    static boolean visit[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int dis[][];

    public static int bfs(int r, int c) {
        visit[r][c] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && !visit[ny][nx] && (board[ny][nx] == 0 || board[ny][nx] == 1)) {
                    if (board[ny][nx] == 1) return dis[cy][cx] + 1;
                    else {
                        visit[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                        dis[ny][nx] = dis[cy][cx] + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        board = new int[5][5];
        visit = new boolean[5][5];
        dis = new int[5][5];
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bufferedReader.readLine());
        System.out.print(bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
}