import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    // 예제 입력 1
    // Joe 16 34
    // Bill 18 65
    // Billy 17 65
    // Sam 17 85
    // # 0 0
    // 예제 출력 1
    // Joe Junior
    // Bill Senior
    // Billy Junior
    // Sam Senior
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        BigInteger sum = new BigInteger(Integer.toString(1));

        for (int i = N; i >= 1; i--) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        int cnt = 0;
        String temp = sum.toString();
        for (int i = temp.length() - 1; i > 0; i--) {
            char c = temp.charAt(i);
            if (c == '0') {
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
}