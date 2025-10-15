import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int board[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static boolean visit[][];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        board = new int[5][5];
        visit = new boolean[5][5];
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bufferedReader.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        visit[r][c] = true;
        dfs(r, c, 0, 0);

        System.out.print(flag ? min : -1);
    }

    static boolean flag = false;
    static int min = Integer.MAX_VALUE;

    public static void dfs(int cy, int cx, int depth, int appleCnt) {
        if (appleCnt == 3) {
            flag = true;
            min = Math.min(min, depth);
        }
        for (int i = 0; i < 4; i++) {
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && !visit[ny][nx] && board[ny][nx] != -1) {
                visit[ny][nx] = true;
                if (board[ny][nx] == 1) dfs(ny, nx, depth + 1, appleCnt + 1);
                else dfs(ny, nx, depth + 1, appleCnt);
                visit[ny][nx] = false;
            }
        }
    }
}