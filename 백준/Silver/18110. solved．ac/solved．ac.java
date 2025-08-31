import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    // 예제 입력 1
    // 5
    // 1
    // 5
    // 5
    // 7
    // 8
    // 예제 출력 1
    // 6
    // 5명의 15%는 0.75명으로, 이를 반올림하면 1명이다. 따라서 solved.ac는 가장 높은 난이도 의견과 가장 낮은 난이도 의견을
    // 하나씩 제외하고, {5, 5, 7}에 대한 평균으로 문제 난이도를 결정한다.

    // 예제 입력 2
    // 10
    // 1
    // 13
    // 12
    // 15
    // 3
    // 16
    // 13
    // 12
    // 14
    // 15
    // 예제 출력 2
    // 13
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arrN[] = new int[N];
        for (int i = 0; i < arrN.length; i++) {
            arrN[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arrN);
        int cut = (int)Math.round(N * 0.15);
        int sum = 0;
        for (int i = cut; i < arrN.length - cut; i++) {
            sum += arrN[i];
        }
        double avg = (double)sum / (N - 2 * cut);
        int result = (int)Math.round(avg);
        System.out.println(result);
    }
}