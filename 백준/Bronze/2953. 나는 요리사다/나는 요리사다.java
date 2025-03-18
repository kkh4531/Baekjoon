import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        int grade = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            if (sum > max) {
                max = sum;
                grade = i + 1;
            }
        }
        System.out.println(grade + " " + max);
    }

}
