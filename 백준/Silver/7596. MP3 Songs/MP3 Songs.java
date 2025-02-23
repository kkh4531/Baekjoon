import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*

 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (true) {
            int N = Integer.parseInt(bufferedReader.readLine());
            if (N == 0) {
                break;
            }
            String tmp[] = new String[N];
            for (int i = 0; i < N; i++) {
                tmp[i] = bufferedReader.readLine();
            }
            Arrays.sort(tmp);
            sb.append(cnt++).append('\n');
            for (int i = 0; i < N; i++) {
                sb.append(tmp[i]).append('\n');
            }
        }
        System.out.println(sb);
    }

}
