import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int s;
    static int[] result;
    static int[] arr;
    static int cnt;
    public static void dfs(int at, int depth) {
        if (depth == m) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += result[i];
            }
            if (sum == s) {
                cnt++;
            }
            return;
        }
        for (int i = at; i < n; i++) {
            result[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            m = i;
            result = new int[m];
            dfs(0, 0);
        }
        System.out.println(cnt);
    }
}