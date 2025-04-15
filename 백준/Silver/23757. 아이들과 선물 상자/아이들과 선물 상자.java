import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(bufferedReader.readLine());
        int result = 1;
        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp > q.peek()) {
                result = 0;
                break;
            }
            int rest = q.poll() - tmp;
            if (rest != 0) {
                q.add(rest);
            }
        }
        System.out.println(result);
    }
}
