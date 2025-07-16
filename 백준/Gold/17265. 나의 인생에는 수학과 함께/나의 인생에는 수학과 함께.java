import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int dy[] = {0, 1};
    static int dx[] = {1, 0};
    static String[][] board;

    public static void dfs(int cy, int cx, int num, String operand) {
        if (cy == n && cx == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        } else {
            for (int i = 0; i < 2; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 1 && ny <= n && nx >= 1 && nx <= n) {
                    if (operand == null) {
                        dfs(ny, nx, num, board[ny][nx]);
                    } else {
                        if (operand.equals("+")) dfs(ny, nx, num + Integer.parseInt(board[ny][nx]), null);
                        else if (operand.equals("-")) dfs(ny, nx, num - Integer.parseInt(board[ny][nx]), null);
                        else dfs(ny, nx, num * Integer.parseInt(board[ny][nx]), null);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        board = new String[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = st.nextToken();
            }
        }

        dfs(1, 1, Integer.parseInt(board[1][1]), null);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append(" ").append(min);
        System.out.print(sb);
    }
}