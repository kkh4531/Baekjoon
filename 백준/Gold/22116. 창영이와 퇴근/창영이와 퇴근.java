import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int maxSlope;

        public Node(int y, int x, int maxSlope) {
            this.y = y;
            this.x = x;
            this.maxSlope = maxSlope;
        }

        @Override
        public int compareTo(Node o) {
            return maxSlope - o.maxSlope;
        }
    }

    static int dis[][];
    static int board[][];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());

        dis = new int[n][n];
        board = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(dijkstra());
    }
    static int n;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    private static int dijkstra() {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int cy = current.y;
            int cx = current.x;
            int maxSlope = current.maxSlope;
            if (maxSlope > dis[cy][cx]) continue;
            if (cy == n - 1 && cx == n - 1) {
                return maxSlope;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                    int tmpSlope = Math.abs(board[ny][nx] - board[cy][cx]);
                    int tmpMaxSlope = Math.max(tmpSlope, maxSlope);
                    if (dis[ny][nx] > tmpMaxSlope) {
                        dis[ny][nx] = tmpMaxSlope;
                        pq.offer(new Node(ny, nx, tmpMaxSlope));
                    }
                }
            }
        }
        return 0;
    }

}