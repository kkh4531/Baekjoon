import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        String first = st.nextToken();
        String second = st.nextToken();


        String tmp1 = "";
        String tmp2 = "";

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == '5')  tmp1 += "6";
            else tmp1 += first.charAt(i);
        }

        for (int i = 0; i < second.length(); i++) {
            if (second.charAt(i) == '5')  tmp2 += "6";
            else tmp2 += second.charAt(i);
        }

        int max = Integer.parseInt(tmp1) + Integer.parseInt(tmp2);

        tmp1 = "";
        tmp2 = "";
        
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == '6')  tmp1 += "5";
            else tmp1 += first.charAt(i);
        }

        for (int i = 0; i < second.length(); i++) {
            if (second.charAt(i) == '6')  tmp2 += "5";
            else tmp2 += second.charAt(i);
        }

        int min = Integer.parseInt(tmp1) + Integer.parseInt(tmp2);

        StringBuilder sb = new StringBuilder();

        sb.append(min).append(" ").append(max);
        System.out.print(sb);
    }
}