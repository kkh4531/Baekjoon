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

        int cnt = 0;

        for (int i = n - 1; i > 0; i--) {
            if (arr[i] <= arr[i - 1]) {
                cnt = cnt + arr[i - 1] - arr[i] + 1;
                arr[i - 1] = arr[i - 1] - (arr[i - 1] - arr[i] + 1);
            }
        }
        System.out.print(cnt);
    }
}