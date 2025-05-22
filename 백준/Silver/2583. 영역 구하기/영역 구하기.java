import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int y;
    static int x;
    static boolean visit[][];
    static int board[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static PriorityQueue<Integer> result;

    public static void bfs(int initY, int initX) {
        Queue<int[]> queue = new LinkedList<>();
        visit[initY][initX] = true;
        queue.offer(new int[]{initY, initX});
        int cnt = 1;
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (nx >= 0 && nx <= x - 1 && ny >= 0 && ny <= y - 1 && !visit[ny][nx] && board[ny][nx] == 0) {
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                    cnt++;
                }
            }
        }
        result.offer(cnt);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[y][x];
        visit = new boolean[y][x];
        result = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int s = x1; s < x2; s++) {
                    board[j][s] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (!visit[i][j] && board[i][j] == 0) {
                    bfs(i, j);
                    cnt++;
                    i = 0;
                    j = -1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n');
        int size = result.size();
        for (int i = 0; i < size; i++) {
            sb.append(result.poll()).append(" ");
        }
        System.out.println(sb);
    }
}