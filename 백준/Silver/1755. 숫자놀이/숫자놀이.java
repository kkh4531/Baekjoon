import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
문제
79를 영어로 읽되 숫자 단위로 하나씩 읽는다면 "seven nine"이 된다. 80은 마찬가지로 "eight zero"라고 읽는다. 79는 80보다 작지만, 영어로 숫자 하나씩 읽는다면 "eight zero"가 "seven nine"보다 사전순으로 먼저 온다.

문제는 정수 M, N(1 ≤ M ≤ N ≤ 99)이 주어지면 M 이상 N 이하의 정수를 숫자 하나씩 읽었을 때를 기준으로 사전순으로 정렬하여 출력하는 것이다.

입력
첫째 줄에 M과 N이 주어진다.

출력
M 이상 N 이하의 정수를 문제 조건에 맞게 정렬하여 한 줄에 10개씩 출력한다.

예제 입력 1
8 28
예제 출력 1
8 9 18 15 14 19 11 17 16 13
12 10 28 25 24 21 27 26 23 22
20
 */
public class Main {

    public static String alphabets[] = {"zero ", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine "};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String results[] = new String[N - M + 1];
        int cnt = 0;
        for (int i = M; i <= N; i++) {
            String temp = String.valueOf(i);
            String res = "";
            for (int j = 0; j < temp.length(); j++) {
                char present = temp.charAt(j);
                switch (present) {
                    case '0' :
                        res += alphabets[0]; break;
                    case '1' :
                        res += alphabets[1]; break;
                    case '2' :
                        res += alphabets[2]; break;
                    case '3' :
                        res += alphabets[3]; break;
                    case '4' :
                        res += alphabets[4]; break;
                    case '5' :
                        res += alphabets[5]; break;
                    case '6' :
                        res += alphabets[6]; break;
                    case '7' :
                        res += alphabets[7]; break;
                    case '8' :
                        res += alphabets[8]; break;
                    case '9' :
                        res += alphabets[9]; break;
                }
            }
            results[cnt++] = res;
        }
        Arrays.sort(results); // 정렬
        int realResults[] = new int[results.length];
        for (int i = 0; i < results.length; i++) {
            String splitTmp[] = results[i].split(" ");
            String res = "";
            for (int j = 0; j < splitTmp.length; j++) {
                switch (splitTmp[j]) {
                    case "zero" :
                        res += "0"; break;
                    case "one" :
                        res += "1"; break;
                    case "two" :
                        res += "2"; break;
                    case "three" :
                        res += "3"; break;
                    case "four" :
                        res += "4"; break;
                    case "five" :
                        res += "5"; break;
                    case "six" :
                        res += "6"; break;
                    case "seven" :
                        res += "7"; break;
                    case "eight" :
                        res += "8"; break;
                    case "nine" :
                        res += "9"; break;
                }
            }
            realResults[i] = Integer.parseInt(res);
        }
        StringBuilder sb = new StringBuilder();
        int cnt2 = 0;
        for (int i = 0; i < realResults.length; i++) {
            if (cnt2 == 9) {
                cnt2 = 0;
                sb.append(realResults[i]).append('\n');
            } else {
                cnt2++;
                sb.append(realResults[i]).append(" ");
            }
        }
        System.out.println(sb);
    }


}
