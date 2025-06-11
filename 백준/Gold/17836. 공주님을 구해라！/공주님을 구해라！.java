import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int y;
    static int x;
    static boolean visit[][][];
    static int board[][];
    static int dis[][][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visit[0][0][0] = true;
        queue.offer(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cz = tmp[0];
            int cy = tmp[1];
            int cx = tmp[2];
            int sword = tmp[3];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (ny >= 0 && ny < y && nx >= 0 && nx < x && !visit[cz][ny][nx] && sword == 1) {
                    visit[cz][ny][nx] = true;
                    queue.offer(new int[]{cz, ny, nx, 1});
                    dis[cz][ny][nx] = dis[cz][cy][cx] + 1;
                } else if (ny >= 0 && ny < y && nx >= 0 && nx < x && !visit[cz][ny][nx]) {
                    if (board[ny][nx] == 2) {
                        visit[cz][ny][nx] = true;
                        queue.offer(new int[]{cz, ny, nx, 0});
                        dis[cz][ny][nx] = dis[cz][cy][cx] + 1;
                        dis[1][ny][nx] = dis[cz][ny][nx];
                        queue.offer(new int[]{1, ny, nx, 1});
                        visit[1][ny][nx] = true;
                    } else if (board[ny][nx] == 0) {
                        visit[cz][ny][nx] = true;
                        queue.offer(new int[]{cz, ny, nx, 0});
                        dis[cz][ny][nx] = dis[cz][cy][cx] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        board = new int[y][x];
        visit = new boolean[2][y][x];
        dis = new int[2][y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < x; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        if (!visit[0][y - 1][x - 1]) { // 그람 없이는 도달할 수 없을 때
            if (dis[1][y - 1][x - 1] > t) sb.append("Fail"); // 그람은 획득했는데 제한시간을 초과했을 때
            else if (!visit[1][y - 1][x - 1]) sb.append("Fail"); // 그람도 얻지 못하여 아예 도달하지 못했을 때
            else sb.append(dis[1][y - 1][x - 1]); // 그람 없이는 도달할 수 없었지만 그람을 획득도 하고 제한 시간 안에 구했을 때
        } else { // 그람 없이는 도달했음
            if (!visit[1][y - 1][x - 1]) { // 아예 그람을 못 구했을 때
                if (dis[0][y - 1][x - 1] > t) sb.append("Fail"); // 그람을 구하지도 못 했고 그람 없이는 도착했으나 제한 시간을 초과했을 때
                else sb.append(dis[0][y - 1][x - 1]); // 그람 없이 도달했고 제한 시간 안에 구했을 때
            } else { // 그람 없이도 도달했고 그람 있이도 도달했을 때
                if (dis[0][y - 1][x - 1] > t) { // 그람 없이 도달했는 데 시간이 초과했을 때
                    if (dis[1][y - 1][x - 1] > t) sb.append("Fail"); // 둘 다 도달은 했으나 시간을 초과했을 때
                    else sb.append(dis[1][y - 1][x - 1]);
                } else { // 그람 없이 도달했고 시간 안에도 도착했을 때
                    if (dis[1][y - 1][x - 1] > t) sb.append(dis[0][y - 1][x - 1]); // 그람 있이 도착했을 때는 시간이 초과했을 때
                    else sb.append(Math.min(dis[1][y - 1][x - 1], dis[0][y - 1][x - 1])); // 둘 다 도착했고 둘 다 시간 안에 왔을 때
                }
            }
        }
        System.out.println(sb);
    }
}