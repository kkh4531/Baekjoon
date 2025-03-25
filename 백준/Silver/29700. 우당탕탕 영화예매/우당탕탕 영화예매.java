import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        if (k > m) {
            System.out.println(cnt);
        } else {
            for (int i = 0; i < n; i++) {
                String seats = bufferedReader.readLine();
                int cntZero = 0;
                for (int j = 0; j < k; j++) {
                    if (seats.charAt(j) == '0') {
                        cntZero++;
                    }
                }
                if (cntZero == k) {
                    cnt++;
                }
                for (int j = k; j < m; j++) {
                    if (seats.charAt(j) == '0') {
                        cntZero++;
                    }
                    if (seats.charAt(j - k) == '0') {
                        cntZero--;
                    }
                    if (cntZero == k) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }

}
