import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int score = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int res = Integer.parseInt(st.nextToken());
            if (res == 0) { // 틀렸을 때
                cnt = 0;
                continue;
            }
            cnt++;
            score += cnt;
        }
        System.out.println(score);
        bufferedReader.close();
    }
}