import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            sb.append("Case ").append(i).append(": ").append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append('\n');
        }
        System.out.println(sb);
    }
}