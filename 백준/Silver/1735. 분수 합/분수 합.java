import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int first[] = new int[2];
        int second[] = new int[2];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        first[0] = Integer.parseInt(st.nextToken());
        first[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());
        second[0] = Integer.parseInt(st.nextToken());
        second[1] = Integer.parseInt(st.nextToken());

        int bunmo = first[1] * second[1];
        int bunza = first[0] * second[1] + second[0] * first[1];

        int m, n = 0; // m이 더 큰애
        if (bunmo > bunza) {
            m = bunmo;
            n = bunza;
        } else {
            m = bunza;
            n = bunmo;
        }
        int gcd = gcd(m, n);
        StringBuilder sb = new StringBuilder();
        sb.append(bunza / gcd).append(" ").append(bunmo / gcd);
        System.out.println(sb);
    }

    public static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        }
        return gcd(n, m % n);
    }
}
