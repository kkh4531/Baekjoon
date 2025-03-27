import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int solution(String str) {
        int cnt = 0;
        Deque<Character> dq = new ArrayDeque<>();
        dq.addLast(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                dq.addLast('(');
            } else { // )
                if (str.charAt(i - 1) == '(') { // 레이저
                    dq.removeLast();
                    cnt += dq.size();
                } else { // 쇠막대기의 끝
                    dq.removeLast();
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();

        System.out.println(solution(str));
    }

}
