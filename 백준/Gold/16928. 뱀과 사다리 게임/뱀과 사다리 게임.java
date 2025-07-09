import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean visit[];
    static Map<Integer, Integer> ladder;
    static Map<Integer, Integer> snake;

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visit[1] = true;
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int num = tmp[0];
            int cnt = tmp[1];
            for (int i = 1; i <= 6; i++) {
                int nv = num + i;
                if (nv <= 100 && !visit[nv]) {
                    if (nv == 100) return cnt + 1;
                    if (ladder.get(nv) != null) {
                        visit[ladder.get(nv)] = true;
                        queue.offer(new int[]{ladder.get(nv), cnt + 1});
                    } else if (snake.get(nv) != null) {
                        if (!visit[snake.get(nv)]) { // 내려간 위치가 아직 방문되지 않은 곳이면
                            visit[snake.get(nv)] = true;
                            queue.offer(new int[]{snake.get(nv), cnt + 1});
                        } // 내려간 위치가 이미 방문한 곳이면 그냥 소멸
                    } else {
                        queue.offer(new int[]{nv, cnt + 1});
                    }
                    visit[nv] = true;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visit = new boolean[101];
        ladder = new HashMap<>();
        snake = new HashMap<>();

        init(n, bufferedReader, true);
        init(m, bufferedReader, false);

        System.out.print(bfs());
    }

    public static void init(int n, BufferedReader br, boolean flag) throws Exception {
        StringTokenizer st;
        if (flag) { // ladder
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                ladder.put(key, value);
            }
        } else {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int key = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                snake.put(key, value);
            }
        }
    }
}