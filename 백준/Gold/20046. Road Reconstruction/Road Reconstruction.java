import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int cost;

        public Node(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static int dis[][];
    static int board[][];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        dis = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (board[0][0] == -1) System.out.print(-1);
        else {
            dijkstra(m, n);
            if (dis[m - 1][n - 1] == Integer.MAX_VALUE) System.out.print(-1);
            else System.out.print(dis[m - 1][n - 1]);
        }
    }

    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    private static void dijkstra(int m, int n) {
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[0][0] = board[0][0];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, board[0][0]));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int cy = current.y;
            int cx = current.x;
            int nowCost = current.cost;
            if (nowCost > dis[cy][cx]) continue;
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 0 && ny < m && nx >= 0 && nx < n && board[ny][nx] != -1 && dis[ny][nx] > nowCost + board[ny][nx]) {
                    dis[ny][nx] = nowCost + board[ny][nx];
                    pq.offer(new Node(ny, nx, nowCost + board[ny][nx]));
                }
            }
        }
    }

}