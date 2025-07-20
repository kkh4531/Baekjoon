import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    // 예제 입력 1
    // 3
    // 1 45000
    // 6 10
    // 13 17
    // 예제 출력 1
    // 45000
    // 30
    // 221
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gCD = gCD(a, b);
            if (i == N-1) {
                sb.append((a*b)/gCD);
            } else {
                sb.append((a*b)/gCD).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int gCD(int a, int b) {
        return (b == 0) ? a : gCD(b, a % b);
    }
}