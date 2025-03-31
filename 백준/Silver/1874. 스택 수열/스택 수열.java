import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    // 예제 입력 1
    // 8
    // 4
    // 3
    // 6
    // 8
    // 7
    // 5
    // 2
    // 1
    // 예제 출력 1
    // +
    // +
    // +
    // +
    // -
    // -
    // +
    // +
    // -
    // +
    // +
    // -
    // -
    // -
    // -
    // -
    // 예제 입력 2
    // 5
    // 1
    // 2
    // 5
    // 3
    // 4
    // 예제 출력 2
    // NO
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n > max) {
                for (int j = max + 1; j <= n; j++) {
                    stack.push(j);
                    sb.append("+").append('\n');
                }
                max = n;
            }

            if (stack.peek() != n) {
                System.out.println("NO");
                System.exit(0);
            }
            stack.pop();
            sb.append("-").append('\n');
        }
        System.out.println(sb);
    }
}