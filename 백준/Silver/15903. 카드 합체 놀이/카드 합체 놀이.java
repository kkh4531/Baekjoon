import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> q = new PriorityQueue<>();
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            long tmp = q.poll();
            long tmp2 = q.poll();
            for (int j = 0; j < 2; j++) {
                q.add(tmp + tmp2);
            }
        }
        long sum = 0;
        while (!q.isEmpty()) {
            sum += q.poll();
        }
        System.out.println(sum);
    }
}
