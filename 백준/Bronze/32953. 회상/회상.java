import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        while (n-- > 0) {
            int numOfSubject = Integer.parseInt(bufferedReader.readLine());
            st = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < numOfSubject; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
        int cnt = 0;
        for (int num : map.keySet()) {
            if (map.get(num) >= m) cnt++;
        }
        System.out.print(cnt);
    }
}