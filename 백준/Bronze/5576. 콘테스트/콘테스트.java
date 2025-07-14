import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> W = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> K = new PriorityQueue<>(Collections.reverseOrder());

        solution(W, bufferedReader);
        solution(K, bufferedReader);

        StringBuilder sb = new StringBuilder();
        sb.append(sum(W)).append(" ");
        sb.append(sum(K));
        System.out.print(sb);
    }

    public static int sum(PriorityQueue<Integer> queue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += queue.poll();
        }
        return sum;
    }

    public static void solution(PriorityQueue<Integer> queue, BufferedReader bufferedReader) throws Exception {
        for (int i = 0; i < 10; i++) {
            queue.add(Integer.parseInt(bufferedReader.readLine()));
        }
    }
}