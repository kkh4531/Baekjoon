import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static boolean bfs(int startX, int startY, int festivalX, int festivalY, List<int[]> coordinates) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int present[] = queue.poll();
            int x = present[0];
            int y = present[1];
            for (int i = 0; i < coordinates.size(); i++) {
                int tmp[] = coordinates.get(i);
                int tmpX = tmp[0];
                int tmpY = tmp[1];
                if (Math.abs(x - tmpX) + Math.abs(y - tmpY) <= 1000) {
                    if (tmpX == festivalX && tmpY == festivalY) return true;
                    queue.offer(new int[]{tmpX, tmpY});
                    coordinates.remove(i);
                    i -= 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int startX = Integer.parseInt(st.nextToken()); // 상근이네 집 좌표 x
            int startY = Integer.parseInt(st.nextToken()); // 상근이네 집 좌표 y

            List<int[]> coordinates = new LinkedList<>();
            for (int j = 0; j < n; j++) { // 편의점 좌표
                st = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                coordinates.add(new int[]{x, y});
            }
            st = new StringTokenizer(bufferedReader.readLine());
            int festivalX = Integer.parseInt(st.nextToken());
            int festivalY = Integer.parseInt(st.nextToken());
            coordinates.add(new int[]{festivalX, festivalY});
            if (bfs(startX, startY, festivalX, festivalY, coordinates)) sb.append("happy").append('\n');
            else sb.append("sad").append('\n');
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}