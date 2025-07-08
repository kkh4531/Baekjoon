import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(bufferedReader.readLine());

        int arr[] = new int[4];
        for (int i = 1; i <= 3; i++) {
            arr[i] = i;
        }
        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(bufferedReader.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            int idx1 = 0;
            for (int i = 1; i <= 3; i++) {
                if (arr[i] == first) idx1 = i;
            }
            int idx2 = 0;
            for (int i = 1; i <= 3; i++) {
                if (arr[i] == second) idx2 = i;
            }
            int tmp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = tmp;
        }
        System.out.println(arr[1]);
    }
}