import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        StringTokenizer st;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == 1) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                if (time == 1) {
                    sum += score;
                } else {
                    stack.push(new int[]{score, time - 1});
                }
            } else {
                if (!stack.isEmpty()) {
                    int tmpArr[] = stack.pop();
                    if (tmpArr[1] == 1) {
                        sum += tmpArr[0];
                    } else {
                        stack.push(new int[]{tmpArr[0], tmpArr[1] - 1});
                    }
                }
            }
        }
        System.out.println(sum);
    }
}