import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String first = bufferedReader.readLine();
            String second = bufferedReader.readLine();

            if (first.equals("END") && second.equals("END")) break;
            char c1[] = first.toCharArray();
            char c2[] = second.toCharArray();

            if (first.length() != second.length()) {
                sb.append("Case ").append(idx++).append(": ").append("different").append('\n');
            } else {
                boolean flag = true;
                Arrays.sort(c1);
                Arrays.sort(c2);
                for (int i = 0; i < c1.length; i++) {
                    if (c1[i] != c2[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sb.append("Case ").append(idx++).append(": ").append("same").append('\n');
                } else {
                    sb.append("Case ").append(idx++).append(": ").append("different").append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}