import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static HashSet<Long> visit;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        visit = new HashSet<>();

        System.out.print(bfs(A, B));
    }

    public static int bfs(long start, long B) {
        Queue<Long> queue = new LinkedList<>();
        visit.add(start);
        queue.offer(start);
        int L = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long current = queue.poll();
                if (current == B) {
                    return L;
                }
                if ((current * 2) <= B && !visit.contains(current * 2)) {
                    queue.offer(current * 2);
                    visit.add(current * 2);
                }
                if ((current * 10 + 1) <= B && !visit.contains(current * 10 + 1)) {
                    queue.offer(current * 10 + 1);
                    visit.add(current * 10 + 1);
                }
            }
            L++;
        }
        return -1;
    }
}