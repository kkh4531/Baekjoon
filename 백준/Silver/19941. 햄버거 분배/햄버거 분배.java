import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char arr[] = new char[n];
        boolean visit[] = new boolean[n];
        String input = bufferedReader.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = input.charAt(i);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                for (int j = k; j >= 1; j--) {
                    if (i - j >= 0 && arr[i - j] == 'H' && !visit[i - j]) {
                        visit[i - j] = true;
                        visit[i] = true;
                        cnt++;
                        break;
                    }
                }
                if (!visit[i]) {
                    for (int j = 1; j <= k; j++) {
                        if (i + j < n && arr[i + j] == 'H' && !visit[i + j]) {
                            visit[i + j] = true;
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}