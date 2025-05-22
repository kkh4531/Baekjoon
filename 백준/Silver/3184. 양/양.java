import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int y;
    static int x;
    static boolean visit[][];
    static char board[][];
    static int VSum = 0;
    static int OSum = 0;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static void bfs(int initY, int initX) {
        visit[initY][initX] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{initY, initX});
        int v = 0;
        int o = 0;
        if (board[initY][initX] == 'v') v++;
        else o++;
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 1 && ny <= y && nx >= 1 && nx <= x && !visit[ny][nx] && board[ny][nx] != '#') {
                    if (board[ny][nx] == 'v') v++;
                    else if (board[ny][nx] == 'o') o++;
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
        total(v, o);
    }

    public static void total(int v, int o) {
        if (v >= o) VSum += v;
        else OSum += o;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        visit = new boolean[y + 1][x + 1];
        board = new char[y + 1][x + 1];
        Queue<int[]> list = new LinkedList<>();

        for (int i = 1; i <= y; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < x; j++) {
                char tmp = input.charAt(j);
                if (tmp == 'v' || tmp == 'o') {
                    list.offer(new int[]{i, j + 1});
                }
                board[i][j + 1] = tmp;
            }
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            int tmp[] = list.poll();
            int y = tmp[0];
            int x = tmp[1];
            if (!visit[y][x]) {
                bfs(y, x);
            }
        }

        System.out.println(OSum + " " + VSum);
    }
}