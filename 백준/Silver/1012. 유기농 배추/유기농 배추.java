import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int k;
    static int board[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        board[y][x] = 0;
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (nx >= 1 && nx <= m && ny >= 1 && ny <= n && board[ny][nx] == 1) {
                    queue.offer(new int[]{ny, nx});
                    board[ny][nx] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            board = new int[n + 1][m + 1];
            Queue<int[]> list = new LinkedList<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y + 1][x + 1] = 1;
                list.offer(new int[]{y + 1, x + 1});
            }
            int size = list.size();
            int cnt = 0;
            for (int j = 0; j < size; j++) {
                int tmp[] = list.poll();
                int y = tmp[0];
                int x = tmp[1];
                if (board[y][x] == 1) {
                    bfs(y, x);
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}