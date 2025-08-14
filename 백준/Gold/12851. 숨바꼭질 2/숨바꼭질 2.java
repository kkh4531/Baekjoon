import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dist;
    static int[] countWays;
    static final int MAX_POS = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dist = new int[MAX_POS + 1];
        countWays = new int[MAX_POS + 1];
        Arrays.fill(dist, -1);

        if (n == k) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        bfs(n, k);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[k]).append('\n').append(countWays[k]);
        System.out.print(sb);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        dist[start] = 0;
        countWays[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX_POS) {
                    if (dist[next] == -1) {
                        dist[next] = dist[current] + 1;
                        countWays[next] = countWays[current];
                        queue.offer(next);
                    }
                    else if (dist[next] == dist[current] + 1) {
                        countWays[next] += countWays[current];
                    }
                }
            }
        }
    }
}