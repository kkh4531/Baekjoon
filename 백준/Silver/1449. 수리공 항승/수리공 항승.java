import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static double P = 0.5;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        double tmp = (arr[0] - P) + L;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] + P > tmp) {
                cnt++;
                tmp = (arr[i] - P) + L;
            }
        }
        System.out.print(cnt);
    }

}