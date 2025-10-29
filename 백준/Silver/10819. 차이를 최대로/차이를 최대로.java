import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n];
        visit = new boolean[n];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        res = new int[n];
        dfs(0);
        System.out.print(max);
    }

    static int n;
    static boolean visit[];
    static int max = Integer.MIN_VALUE;
    static int res[];
    static int arr[];

    private static void dfs(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(res[i] - res[i + 1]);
            }
            max = Math.max(max, sum);
        } else {
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    res[depth] = arr[i];
                    dfs(depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}