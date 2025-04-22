import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int centi = Integer.parseInt(st.nextToken());
        int hammer = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(bufferedReader.readLine()));
        }
        int cnt = 0;
        for (int i = 0; i < hammer; i++) {
            if (q.peek() == 1 || q.peek() < centi) {
                break;
            }
            q.add(q.poll() / 2);
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        if (q.peek() >= centi) {
            sb.append("NO").append('\n').append(q.poll());
        } else {
            sb.append("YES").append('\n').append(cnt);
        }
        System.out.println(sb);
    }
}