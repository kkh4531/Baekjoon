import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp < n) pq.offer(tmp);
            else cnt++;
        }
        int res = 0;

        for (int i = 0; i < m - 1 - cnt; i++) {
            res = res + (n - pq.poll());
        }

        System.out.print(res);
    }
}