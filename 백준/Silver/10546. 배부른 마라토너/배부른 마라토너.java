import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    // 마라토너라면 국적과 나이를 불문하고 누구나 참가하고 싶어하는 백준 마라톤 대회가 열린다. 42.195km를 달리는 이 마라톤은 모두가
    // 참가하고 싶어했던 만큼 매년 모두가 완주해왔다. 단, 한 명만 빼고!

    // 모두가 참가하고 싶어서 안달인데 이런 백준 마라톤 대회에 참가해 놓고 완주하지 못한 배부른 참가자 한 명은 누굴까?

    // 입력
    // 첫째 줄에는 참가자 수 N이 주어진다. (1 ≤ N ≤ 105)

    // N개의 줄에는 참가자의 이름이 주어진다.

    // 추가적으로 주어지는 N-1개의 줄에는 완주한 참가자의 이름이 쓰여져 있다.

    // 참가자들의 이름은 길이가 1보다 크거나 같고, 20보다 작거나 같은 문자열이고, 알파벳 소문자로만 이루어져 있다.

    // 참가자들 중엔 동명이인이 있을 수도 있다.

    // 출력
    // 마라톤을 완주하지 못한 참가자의 이름을 출력한다.

    // 예제 입력 1
    // 3
    // leo
    // kiki
    // eden
    // eden
    // kiki
    // 예제 출력 1
    // leo
    // 예제 입력 2
    // 5
    // marina
    // josipa
    // nikola
    // vinko
    // filipa
    // josipa
    // filipa
    // marina
    // nikola
    // 예제 출력 2
    // vinko
    // 예제 입력 3
    // 4
    // mislav
    // stanko
    // mislav
    // ana
    // stanko
    // ana
    // mislav
    // 예제 출력 3
    // mislav
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for (int i = 0; i < N - 1; i++) {
            String name = br.readLine();
            map.put(name, map.get(name) - 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
