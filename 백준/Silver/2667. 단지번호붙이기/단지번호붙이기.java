import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static boolean visit[][];
    static int board[][];
    static PriorityQueue<Integer> pq;
    static int danjiCnt = 0;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 1 && !visit[i][j]) {
                    int cnt = 1;
                    visit[i][j] = true;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int tmp[] = queue.poll();
                        int cy = tmp[0];
                        int cx = tmp[1];
                        for (int k = 0; k < 4; k++) {
                            int ny = cy + dy[k];
                            int nx = cx + dx[k];
                            if (ny >= 1 && ny <= n && nx >= 1 && nx <= n && board[ny][nx] == 1 && !visit[ny][nx]) {
                                visit[ny][nx] = true;
                                queue.offer(new int[]{ny, nx});
                                cnt++;
                            }
                        }
                    }
                    danjiCnt++;
                    pq.add(cnt);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        visit = new boolean[n + 1][n + 1];
        board = new int[n + 1][n + 1];
        pq = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                char tmp = str.charAt(j);
                if (tmp == '1') board[i][j + 1] = 1;
                else board[i][j + 1] = 0;
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        sb.append(danjiCnt).append('\n');
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

}