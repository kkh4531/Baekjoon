import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        visit = new boolean[n + 1];
        int res[] = new int[n + 1];

        dfs(1, 1, res);
        System.out.print(sb);
    }
    static int n;
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();

    private static void dfs(int v, int depth, int res[]) {
        if (depth == n + 1) {
            for (int i = 1; i <= n; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    res[depth] = i;
                    visit[i] = true;
                    dfs(i, depth + 1, res);
                    visit[i] = false;
                }
            }
        }
    }
}