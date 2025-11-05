import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        arr[1] = 1;
        arr[2] = 1;

        fib(N);
        recursiveCall++;
        fibonacci(N);

        System.out.println(recursiveCall);
        System.out.println(dynamicCall);
    }

    // 0 1 1 2 3 5 8 ....
    static int recursiveCall = 0;
    static int dynamicCall = 0;
    static int arr[];

    static int fib(int N) {
        if (N == 1 || N == 2) {
            return 1;
        } else {
            recursiveCall++;
            return fib(N - 1) + fib(N - 2);
        }
    }

    static void fibonacci(int N) {
        for (int i = 3; i < N + 1; i++) {
            dynamicCall++;
            arr[i] = arr[i - 1] + arr[i - 2];
        }
    }
}