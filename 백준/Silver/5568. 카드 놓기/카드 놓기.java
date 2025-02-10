import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static boolean[] visited;
    static String[] arr;
    static HashSet<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        k = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[n];
        set = new HashSet<>();

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = bufferedReader.readLine();
        }

        dfs(0, "");
        System.out.println(set.size());
    }

    static void dfs(int count, String tmp) {
        if (count == k) {
            set.add(tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(count + 1, tmp + arr[i]);
                visited[i] = false;
            }
        }
    }
}