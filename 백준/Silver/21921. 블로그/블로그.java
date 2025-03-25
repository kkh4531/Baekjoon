import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int init = sum;
        int max = sum;
        int lt = 0;
        int cnt = 0;
        for (int rt = k; rt < n; rt++) {
            sum = sum - arr[lt++] + arr[rt];
            if (sum > max) {
                max = sum;
            }
        }
        if (init == max) {
            cnt++;
        }
        lt = 0;
        for (int rt = k; rt < n; rt++) {
            init = init - arr[lt++] + arr[rt];
            if (init == max) {
                cnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (max == 0) {
            sb.append("SAD");
        } else {
            sb.append(max).append('\n').append(cnt);
        }
        System.out.println(sb);
    }

}
