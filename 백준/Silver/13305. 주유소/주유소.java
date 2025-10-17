import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int distance[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bufferedReader.readLine());
        int gasoline[] = new int[n];
        for (int i = 0; i < n; i++) {
            gasoline[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            if (gasoline[i] - gasoline[i + 1] < 0) {
                gasoline[i + 1] = gasoline[i];
            }
        }

        long res = 0;
        for (int i = 0; i < n - 1; i++) {
            res += (long) gasoline[i] * distance[i];
        }

        System.out.print(res);
    }
}