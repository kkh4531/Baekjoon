import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        Map<Integer, Integer> map = new TreeMap<>();
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int present = Integer.parseInt(st.nextToken());
        int first = present;
        set.add(present);
        for (int i = 0; i < n - 1; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (set.add(next)) { // set에 없었던 숫자이면 새로운 숫자가 들어갔음.
                map.put(next, present);
            }
            present = next;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append('\n');
        for (int i = 0; i < set.size(); i++) {
            if (i == first) sb.append(-1).append(" ");
            else {
                sb.append(map.get(i)).append(" ");
            }
        }
        System.out.print(sb);
    }
}