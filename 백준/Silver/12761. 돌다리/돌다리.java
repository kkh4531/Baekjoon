import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean visit[] = new boolean[100001];
    static int SIZE = 100000;

    private static int bfs(int A, int B, int N, int M) {
        Queue<Integer> queue = new LinkedList<>();
        visit[N] = true;
        queue.offer(N);

        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == M) return L;
                if (current + 1 >= 0 && current + 1 <= SIZE && !visit[current + 1]) {
                    queue.offer(current + 1);
                    visit[current + 1] = true;
                }
                if (current - 1 >= 0 && current - 1 <= SIZE && !visit[current - 1]) {
                    queue.offer(current - 1);
                    visit[current - 1] = true;
                }
                if (current + A >= 0 && current + A <= SIZE && !visit[current + A]) {
                    queue.offer(current + A);
                    visit[current + A] = true;
                }
                if (current + B >= 0 && current + B <= SIZE && !visit[current + B]) {
                    queue.offer(current + B);
                    visit[current + B] = true;
                }
                if (current - A >= 0 && current - A <= SIZE && !visit[current - A]) {
                    queue.offer(current - A);
                    visit[current - A] = true;
                }
                if (current - B >= 0 && current - B <= SIZE && !visit[current - B]) {
                    queue.offer(current - B);
                    visit[current - B] = true;
                }
                if (current * A >= 0 && current * A <= SIZE && !visit[current * A]) {
                    queue.offer(current * A);
                    visit[current * A] = true;
                }
                if (current * B >= 0 && current * B <= SIZE && !visit[current * B]) {
                    queue.offer(current * B);
                    visit[current * B] = true;
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.print(bfs(A, B, N, M));
    }
}