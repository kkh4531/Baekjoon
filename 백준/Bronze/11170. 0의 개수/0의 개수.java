import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int T = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;
        while (T-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int cnt = 0;
            for (int i = N; i <= M; i++) {
                String temp = String.valueOf(i);
                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) == '0') {
                        cnt++;
                    }
                }
            }
            stringBuilder.append(cnt).append('\n');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }

}