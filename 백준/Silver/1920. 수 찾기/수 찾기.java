import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    // N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

    // 입력
    // 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
    // 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면
    // 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

    // 출력
    // M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

    // 예제 입력 1
    // 5
    // 4 1 5 2 3
    // 5
    // 1 3 7 9 5
    // 예제 출력 1
    // 1
    // 1
    // 0
    // 0
    // 1
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int arrN[] = new int[N];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);
        int M = Integer.parseInt(reader.readLine());
        int arrM[] = new int[M];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(arrN, arrM[i])).append('\n');
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = arr[middle];

            if (num > middleValue) {
                left = middle + 1;
            } else if (num < middleValue) {
                right = middle - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}