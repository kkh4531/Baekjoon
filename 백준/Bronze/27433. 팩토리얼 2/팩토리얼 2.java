import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    // 예제 입력 1
    // 3
    // 1 45000
    // 6 10
    // 13 17
    // 예제 출력 1
    // 45000
    // 30
    // 221
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(reader.readLine());
        
        if (N == 0) {
            System.out.println(1);
        } else {
            System.out.println(factorial(N));
        }
        
    }

    public static long factorial(long N) {
        if (N == 1) {
            return 1;
        }
        return N * factorial(N - 1);
    }
}