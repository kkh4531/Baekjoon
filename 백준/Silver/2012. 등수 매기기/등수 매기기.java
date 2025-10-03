import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int arr[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        long cnt = 0;

        Arrays.sort(arr);
        for (int i = 1; i <= n; i++) {
            cnt += Math.abs(i - arr[i]);
        }
        
        System.out.print(cnt);
    }
}