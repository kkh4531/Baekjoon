import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bufferedReader.readLine().split(":");

        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);

        int gcd = gcd(n, m);

        System.out.println(n / gcd + ":" + m / gcd);
    }

    public static int gcd(int n, int m) {
        int max = n;
        int min = m;
        if (m > n) {
            max = m;
            min = n;
        }
        if (max % min == 0) {
            return min;
        } else {
            return gcd(min, max % min);
        }
    }

}
