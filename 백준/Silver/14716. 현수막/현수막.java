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

    public static void bfs(int initY, int initX) {
        Queue<int[]> queue = new LinkedList<>();
        visit[initY][initX] = true;
        queue.offer(new int[]{initY, initX});
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 8; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 1 && ny <= y && nx >= 1 && nx <= x && board[ny][nx] == 1 && !visit[ny][nx]) {
                    queue.offer(new int[]{ny, nx});
                    visit[ny][nx] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visit = new boolean[y + 1][x + 1];
        board = new int[y + 1][x + 1];

        Queue<int[]> list = new LinkedList<>();
        for (int i = 1; i <= y; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= x; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    list.offer(new int[]{i, j});
                    board[i][j] = 1;
                }
            }
        }

        int size = list.size();
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            int tmp[] = list.poll();
            int tmpY = tmp[0];
            int tmpX = tmp[1];
            if (!visit[tmpY][tmpX]) {
                bfs(tmpY, tmpX);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}