import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            // if (N == 1) {
            //     sb.append(0 + " " + 1).append('\n');
            //     continue;
            // } else if (N == 0) {
            //     sb.append(1 + " " + 0).append('\n');
            //     continue;
            // }
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;
            fibonacci(N);
            sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
        }
        System.out.println(sb);
    }

    static Integer dp[][] = new Integer[41][2];

    public static Integer[] fibonacci(int N) {
        if(dp[N][0] == null || dp[N][1] == null) {
            dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
            dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
        }
        return dp[N];
    }
    // 예제 입력 1
    // 3
    // 0
    // 1
    // 3
    // 예제 출력 1
    // 1 0
    // 0 1
    // 1 2
    // 예제 입력 2
    // 2
    // 6
    // 22
    // 예제 출력 2
    // 5 8
    // 10946 17711
}