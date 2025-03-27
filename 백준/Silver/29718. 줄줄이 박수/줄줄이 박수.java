import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int a = Integer.parseInt(bufferedReader.readLine());

        int sum = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[j][i];
            }
        }
        int max = sum;
        for (int rt = a; rt < m; rt++) {
            int removeColumn = 0;
            for (int j = 0; j < n; j++) {
                removeColumn += arr[j][rt-a];
            }
            int addColumn = 0;
            for (int j = 0; j < n; j++) {
                addColumn += arr[j][rt];
            }
            sum = sum - removeColumn + addColumn;
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }

}
