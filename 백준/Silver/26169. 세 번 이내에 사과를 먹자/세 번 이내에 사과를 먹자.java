import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int board[][];
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
        System.out.print(flag ? 1 : 0);
    }

    static boolean flag = false;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    private static void dfs(int r, int c, int depth, int cnt) {
        if (depth == 3) {
            if (cnt >= 2) {
                flag = true;
            }
        } else if (cnt >= 2) {
            flag = true;
        } else {
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (flag) return;
                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && board[nr][nc] != -1 && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    if (board[nr][nc] == 0) dfs(nr, nc, depth + 1, cnt);
                    else dfs(nr, nc, depth + 1, cnt + 1);
                    visit[nr][nc] = false;
                }
            }
        }
    }
}