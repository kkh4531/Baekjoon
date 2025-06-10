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
    static int maxArea = 0;

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
                if (ny >= 0 && ny < y && nx >= 0 && nx < x && !visit[ny][nx] && board[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                    cnt++;
                }
            }
        }
        maxArea = Math.max(maxArea, cnt);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        visit = new boolean[y][x];
        board = new int[y][x];
        Queue<int[]> list = new LinkedList<>();
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < x; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    board[i][j] = 1;
                    list.offer(new int[]{i, j});
                }
            }
        }
        int size = list.size();
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            int tmp[] = list.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            if (!visit[cy][cx]) {
                bfs(cy, cx);
                cnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n').append(maxArea);
        System.out.println(sb);
    }
}