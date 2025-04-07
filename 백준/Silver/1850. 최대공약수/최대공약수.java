import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        BigInteger m = new BigInteger(st.nextToken());
        BigInteger n = new BigInteger(st.nextToken());

        if (m.compareTo(n) == -1) {
            BigInteger tmp = m;
            m = n;
            n = tmp;
        }
        BigInteger res = gcd(m, n);
        StringBuilder sb = new StringBuilder();
        int intValue = res.intValue();
        for (int i = 0; i < intValue; i++) {
            sb.append("1");
        }
        System.out.println(sb);
    }

    public static BigInteger gcd(BigInteger m, BigInteger n) {
        if (m.remainder(n).equals(BigInteger.ZERO)) {
            return n;
        }
        return gcd(n, m.remainder(n));
    }
}
