import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int l;
    static boolean visit[][];
    static int dis[][];
    static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void bfs(int initY, int initX, int ty, int tx) {
        Queue<int[]> queue = new LinkedList<>();
        visit[initY][initX] = true;
        queue.offer(new int[]{initY, initX});
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0];
            int cx = tmp[1];
            for (int i = 0; i < 8; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 0 && ny < l && nx >= 0 && nx < l && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    dis[ny][nx] = dis[cy][cx] + 1;
                    if (ny == ty && nx == tx) {
                        return;
                    }
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(bufferedReader.readLine());
            visit = new boolean[l][l];
            dis = new int[l][l];
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int initY = Integer.parseInt(st.nextToken());
            int initX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bufferedReader.readLine());
            int ty = Integer.parseInt(st.nextToken());
            int tx = Integer.parseInt(st.nextToken());
            bfs(initY, initX, ty, tx);
            sb.append(dis[ty][tx]).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}