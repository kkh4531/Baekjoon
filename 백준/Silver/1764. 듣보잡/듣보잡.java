import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    // 예제 입력
    // 3 4
    // ohhenrie
    // charlie
    // baesangwook
    // obama
    // baesangwook
    // ohhenrie
    // clinton
    // 예제 출력 1
    // 2
    // baesangwook
    // ohhenrie
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> list = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            set.add(reader.readLine());
        }
        for (int i = 0; i < M; i++) {
            String name = reader.readLine();
            if (!set.add(name)) {
                list.add(name);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (String names : list) {
            System.out.println(names);
        }
    }
}