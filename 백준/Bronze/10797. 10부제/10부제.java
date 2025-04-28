import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int arr[] = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (n == arr[i] % 10) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}