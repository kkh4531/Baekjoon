import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(bufferedReader.readLine());
        Arrays.sort(arr);
        int leftPointer = 1;
        int rightPointer = n;

        int cnt = 0;
        while (leftPointer < rightPointer) {
            int left = arr[leftPointer];
            int right = arr[rightPointer];
            if (left + right > x) rightPointer--;
            else if (left + right < x) leftPointer++;
            else {
                leftPointer++;
                rightPointer--;
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}