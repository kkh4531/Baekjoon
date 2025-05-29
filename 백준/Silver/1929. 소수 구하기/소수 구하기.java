import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Arrays;

public class Main {
    // M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

    // 입력
    // 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상
    // 있는 입력만 주어진다.

    // 출력
    // 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

    // 예제 입력 1
    // 3 16
    // 예제 출력 1
    // 3
    // 5
    // 7
    // 11
    // 13
    public static int prime[];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        prime = new int[N + 1];

        make_prime(M, N);
    }

    public static void make_prime(int M, int N) {
        prime[0] = prime[1] = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            prime[i] = i;
        }
        for (int i = 2; i <= N; i++) {
            if (prime[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= N; j += i) {
                prime[j] = 0;
            }
        }
        for (int i = M; i <= N; i++) {
            if (prime[i] != 0) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}