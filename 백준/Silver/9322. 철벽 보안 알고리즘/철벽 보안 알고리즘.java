import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine()); // 테스트 케이스
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            String public1[] = bufferedReader.readLine().split(" ");
            String public2[] = bufferedReader.readLine().split(" ");
            String secret[] = bufferedReader.readLine().split(" ");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < public2.length; i++) {
                String temp2 = public2[i];
                for (int j = 0; j < public1.length; j++) {
                    if (temp2.equals(public1[j])) {
                        list.add(j);
                    }
                }
            }
            String res[] = new String[N];
            for (int i = 0; i < list.size(); i++) {
                int index = list.get(i); // 3
                res[index] = secret[i];
            }

            for (int i = 0; i < N; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
