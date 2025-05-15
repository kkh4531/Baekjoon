import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int k;
    static int board[][];
    static boolean visit[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        board[start[0]][start[1]] = 0;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 1 && ny <= n && nx >= 1 && nx <= m && board[ny][nx] == 1) {
                    board[ny][nx] = 0;
                    queue.offer(new int[]{ny, nx});
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];
        Queue<int[]> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 1;
            list.offer(new int[]{r, c});
        }
        int size = list.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            int tmp[] = list.poll();
            int y = tmp[0];
            int x = tmp[1];
            if (board[y][x] == 1) {
                max = Math.max(max, bfs(tmp));
            }
        }
        System.out.println(max);
    }
}