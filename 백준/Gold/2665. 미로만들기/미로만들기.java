import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int n;
    static int board[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int dis[][];
    static class Room {
        int r;
        int c;
        int changes;

        public Room(int r, int c, int changes) {
            this.r = r;
            this.c = c;
            this.changes = changes;
        }
    }

    public static int bfs() {
        Deque<Room> dq = new ArrayDeque<>();
        dq.addFirst(new Room(0, 0, 0));

        while (!dq.isEmpty()) {
            Room currentRoom = dq.removeFirst();
            int cy = currentRoom.r;
            int cx = currentRoom.c;
            int currentChanges = currentRoom.changes;

            if (currentChanges > dis[cy][cx]) {
                continue;
            }

            if (cy == n - 1 && cx == n - 1) {
                return currentChanges;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                    int cost = (board[ny][nx] == 0 ? 1 : 0);
                    int newChanges = currentChanges + cost;
                    if (dis[ny][nx] > newChanges) {
                        dis[ny][nx] = newChanges;
                        if (cost == 0) {
                            dq.addFirst(new Room(ny, nx, newChanges));
                        } else {
                            dq.addLast(new Room(ny, nx, newChanges));
                        }
                    }
                }
            }
        }
        return dis[n - 1][n - 1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        board = new int[n][n];
        dis = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }

        dis[0][0] = 0;
        System.out.print(bfs());
    }
}