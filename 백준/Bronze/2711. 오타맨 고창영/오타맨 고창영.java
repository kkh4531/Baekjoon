import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int idx = Integer.parseInt(st.nextToken());
            String input = st.nextToken();
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                if (!(j == idx - 1)) {
                    tmp.append(input.charAt(j));
                }
            }
            sb.append(tmp.toString()).append('\n');
        }
        System.out.print(sb);
    }
}