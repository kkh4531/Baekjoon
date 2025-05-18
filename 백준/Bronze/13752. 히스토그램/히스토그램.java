import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int tmp = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < tmp; j++) {
                sb.append("=");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}