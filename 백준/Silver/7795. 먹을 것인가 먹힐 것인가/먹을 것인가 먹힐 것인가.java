import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int aSize = Integer.parseInt(st.nextToken());
            int bSize = Integer.parseInt(st.nextToken());
            int a[] = new int[aSize];
            int b[] = new int[bSize];
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < aSize; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < bSize; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            Arrays.sort(b);
            for (int j = 0; j < aSize; j++) {
                cnt += binarySearch(a[j], b);
            }
            sb.append(cnt).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
    public static int binarySearch(int t, int[] b) {
        int cnt = b.length;
        if (t > b[b.length - 1]) {
            return cnt;
        } else if (t < b[0]) {
            return 0;
        }
        int lt = 0;
        int rt = b.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (b[mid] >= t) {
                cnt -= (rt - mid + 1);
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return cnt;
    }
}
