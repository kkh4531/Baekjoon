import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            st = new StringTokenizer(bufferedReader.readLine());
            String tmp = "";
            for (int j = 0; j < n; j++) {
                tmp = tmp.concat(st.nextToken());
            }
            Deque<Character> dq = new ArrayDeque<>();
            dq.add(tmp.charAt(0));
            for (int j = 1; j < tmp.length(); j++) {
                char c = tmp.charAt(j);
                if (dq.getFirst() >= c) dq.addFirst(c);
                else dq.addLast(c);
            }
            for (char c : dq) {
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}