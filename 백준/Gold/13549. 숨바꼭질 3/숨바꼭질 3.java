import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    static final int MAX = 200000;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        if (n == k) {
            System.out.println(0);
            return;
        }

        bfs(n, k);
        System.out.println(dist[k]);
    }

    private static void bfs(int n, int k) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(n);
        dist[n] = 0;
        while (!dq.isEmpty()) {
            int currentPos = dq.removeFirst();
            if (currentPos == k) {
                return;
            }

            int nextPosTeleport = currentPos * 2;
            if (nextPosTeleport >= 0 && nextPosTeleport <= MAX) {
                if (dist[nextPosTeleport] == -1 || dist[nextPosTeleport] > dist[currentPos]) {
                    dist[nextPosTeleport] = dist[currentPos];
                    dq.addFirst(nextPosTeleport);
                }
            }

            int nextPosUp = currentPos + 1;
            int nextPosDown = currentPos - 1;

            if (nextPosUp >= 0 && nextPosUp <= MAX) {
                if (dist[nextPosUp] == -1 || dist[nextPosUp] > dist[currentPos] + 1) {
                    dist[nextPosUp] = dist[currentPos] + 1;
                    dq.addLast(nextPosUp);
                }
            }

            if (nextPosDown >= 0 && nextPosDown <= MAX) {
                if (dist[nextPosDown] == -1 || dist[nextPosDown] > dist[currentPos] + 1) {
                    dist[nextPosDown] = dist[currentPos] + 1;
                    dq.addLast(nextPosDown);
                }
            }
        }
    }
}