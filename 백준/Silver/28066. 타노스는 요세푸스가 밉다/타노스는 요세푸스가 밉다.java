import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }
        int result = 0;
        int first = dq.getFirst();
        while (dq.size() != 1) {
            dq.addLast(dq.pollFirst());
            for (int i = 0; i < k - 1; i++) {
                if (dq.size() > 1) {
                    dq.removeFirst();
                }
            }
            if (dq.size() >= 2) {
                first = dq.getFirst();
                if (dq.size() < k) {
                    result = first;
                    break;
                }
            } else {
                result = first;
                break;
            }
        }

        System.out.println(result);
    }

}
