import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int vertex[];
        int cost;

        public Node(int vertex[], int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n;
    static int dis[][];
    static int board[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis[0][0] = board[0][0];
        pq.offer(new Node(new int[]{0, 0}, board[0][0]));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int nowVertex[] = current.vertex;
            int nowCost = current.cost;
            if (nowCost > dis[nowVertex[0]][nowVertex[1]]) continue;
            for (int i = 0; i < 4; i++) {
                int ny = nowVertex[0] + dy[i];
                int nx = nowVertex[1] + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                    if (dis[ny][nx] > nowCost + board[ny][nx]) {
                        dis[ny][nx] = nowCost + board[ny][nx];
                        pq.offer(new Node(new int[]{ny, nx}, nowCost + board[ny][nx]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (true) {
            st = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            dis = new int[n][n];
            board = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(dis[i], Integer.MAX_VALUE);
            }
            dijkstra();
            sb.append("Problem ").append(idx++).append(": ").append(dis[n - 1][n - 1]).append('\n');
        }
        System.out.print(sb);
    }

}