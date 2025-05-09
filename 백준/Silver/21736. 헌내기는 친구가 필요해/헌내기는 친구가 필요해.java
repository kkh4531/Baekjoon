import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int cnt = 0;
    static boolean visit[][];
    static char board[][];
    static Queue<int[]> queue;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static void bfs() {
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (nx >= 1 && nx <= m && ny >= 1 && ny <= n && !visit[ny][nx] && board[ny][nx] != 'X') {
                    if (board[ny][nx] == 'P') cnt++;
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1][m + 1];
        board = new char[n + 1][m + 1];
        queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'I') {
                    visit[i][j + 1] = true;
                    queue.offer(new int[]{i, j + 1});
                }
                board[i][j + 1] = str.charAt(j);
            }
        }
        bfs();
        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }
}