import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                int locker = Integer.parseInt(st.nextToken());
                int ballingWeight = Integer.parseInt(st.nextToken());
                map.put(ballingWeight, locker);
            } else {
                int ballingWeight = Integer.parseInt(st.nextToken());
                sb.append(map.get(ballingWeight)).append('\n');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}