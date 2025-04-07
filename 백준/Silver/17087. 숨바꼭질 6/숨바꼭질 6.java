import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (n == 1) {
            System.out.println(Math.abs(s - arr[0]));
        } else {
            int results[] = new int[n];
            results[0] = Math.abs(s - arr[0]);
            for (int i = 1; i < n; i++) {
                results[i] = Math.abs(arr[i] - arr[i - 1]);
            }
            int m = results[0];
            int n2 = results[1];
            if (n2 > m) {
                int tmp = n2;
                n2 = m;
                m = tmp;
            }
            int res = gcd(m, n2);
            for (int i = 2; i < n; i++) {
                int tempM = res;
                int tempN = results[i];
                if (tempN > tempM) {
                    int tmp = tempN;
                    tempN = tempM;
                    tempM = tmp;
                }
                res = gcd(tempM, tempN);
            }
            System.out.println(res);
        }
    }

    public static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        }
        return gcd(n, m % n);
    }
}
