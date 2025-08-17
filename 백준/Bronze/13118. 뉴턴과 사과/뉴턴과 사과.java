import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX_POS = 100000;
    static int dis[];
    static int cnt;
    static int level;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int arr[] = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bufferedReader.readLine());
        int x = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            if (arr[i] == x) {
                flag = true;
                sb.append(i + 1);
                break;
            }
        }
        if (!flag) System.out.println(0);
        else System.out.println(sb);
    }

    private static void dijkstra(int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        dis[n] = 0;
        queue.offer(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int nowVertex = tmp[0];
            int nowCost = tmp[1];
            if (nowCost > dis[nowVertex]) continue;
            int arr[] = {nowVertex * 2, nowVertex + 1, nowVertex - 1};
            for (int nv : arr) {
                if (nv >= 0 && nv <= MAX_POS) {
                    if (nv == k) {
                        if (dis[k] >= nowCost + 1) {
                            dis[k] = nowCost + 1;
                            level = nowCost + 1;
                            cnt++;
                        }
                    } else {
                        if (dis[nv] > nowCost + 1) {
                            dis[nv] = nowCost + 1;
                            queue.offer(new int[]{nv, nowCost + 1});
                        }
                    }
                }
            }
        }
    }

}