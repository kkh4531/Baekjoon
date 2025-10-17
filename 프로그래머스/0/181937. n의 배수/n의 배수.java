import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
/*
* 정수 num과 n이 매개 변수로 주어질 때, num이 n의 배수이면 1을 return n의 배수가 아니라면 0을 return하도록 solution 함수를 완성해주세요.*/
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int num = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        System.out.print(solution(num, n));
    }

    public static int solution(int num, int n) {
        if (num % n == 0) return 1;
        else return 0;
    }
}