import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = arr[i] * (n - i);
            max = Math.max(max, tmp);
        }

        System.out.print(max);
    }
}