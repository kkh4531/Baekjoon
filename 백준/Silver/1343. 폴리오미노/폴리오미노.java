import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int a = 0;
        int b = 0;
        int A = 0;
        int B = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '.' && cnt != 0) {
                a = cnt % 4;
                b = a % 2;
                if (b != 0) {
                    System.out.print(-1);
                    return;
                }
                A = cnt / 4;
                B = a / 2;
                for (int j = 0; j < A; j++) {
                    sb.append("AAAA");
                }
                for (int j = 0; j < B; j++) {
                    sb.append("BB");
                }
                cnt = 0;
                sb.append(".");
            } else if (c == '.' && cnt == 0) {
                sb.append(".");
            } else {
                cnt++;
            }
        }
        a = cnt % 4;
        b = a % 2;
        if (b != 0) {
            System.out.print(-1);
            return;
        }
        A = cnt / 4;
        B = a / 2;
        for (int j = 0; j < A; j++) {
            sb.append("AAAA");
        }
        for (int j = 0; j < B; j++) {
            sb.append("BB");
        }
        System.out.println(sb);
    }
}