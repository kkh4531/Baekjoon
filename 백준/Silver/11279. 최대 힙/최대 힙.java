import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // poll할 경우 제일 작은 수가 나옴. maxHeap은 (Collections.reverseOrder())하면 됨
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String tmp = bufferedReader.readLine();
            if (tmp.equals("0")) {
                if (maxHeap.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(maxHeap.poll()).append('\n');
                }
            } else {
                maxHeap.add(Integer.parseInt(tmp));
            }
        }
        System.out.println(sb);
    }
}
