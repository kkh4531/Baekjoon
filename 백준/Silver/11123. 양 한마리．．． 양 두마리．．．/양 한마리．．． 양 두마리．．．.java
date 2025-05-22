import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int y;
    static int x;
    static boolean visit[][];
    static char board[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static void bfs(int initY, int initX) {
        Queue<int[]> queue = new LinkedList<>();
        visit[initY][initX] = true;
        queue.offer(new int[]{initY, initX});
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 1 && ny <= y && nx >= 1 && nx <= x && !visit[ny][nx] && board[ny][nx] == '#') {
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            visit = new boolean[y + 1][x + 1];
            board = new char[y + 1][x + 1];
            Queue<int[]> list = new LinkedList<>();
            for (int j = 1; j <= y; j++) {
                String input = bufferedReader.readLine();
                for (int k = 0; k < x; k++) {
                    char tmp = input.charAt(k);
                    if (tmp == '#') {
                        list.offer(new int[]{j, k + 1});
                    }
                    board[j][k + 1] = tmp;
                }
            }
            int size = list.size();
            int cnt = 0;
            for (int k = 0; k < size; k++) {
                int tmp[] = list.poll();
                int y = tmp[0];
                int x = tmp[1];
                if (!visit[y][x]) {
                    bfs(y, x);
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}