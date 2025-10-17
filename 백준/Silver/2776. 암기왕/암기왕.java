import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            int m = Integer.parseInt(bufferedReader.readLine());
            st = new StringTokenizer(bufferedReader.readLine());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                if (set.contains(Integer.parseInt(st.nextToken()))) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
            System.out.print(sb);
        }
    }
}