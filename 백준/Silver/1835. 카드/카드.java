import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(bufferedReader.readLine());

        deque.add(n);
        for (int i = n - 1; i >= 1; i--) {
            deque.addFirst(i);
            for (int j = 0; j < i; j++) {
                deque.addFirst(deque.pollLast());
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }

}
