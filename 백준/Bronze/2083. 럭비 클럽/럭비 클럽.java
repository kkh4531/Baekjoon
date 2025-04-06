import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    // 예제 입력 1
    // Joe 16 34
    // Bill 18 65
    // Billy 17 65
    // Sam 17 85
    // # 0 0
    // 예제 출력 1
    // Joe Junior
    // Bill Senior
    // Billy Junior
    // Sam Senior
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if ((name.equals("#")) && (age == 0) && (weight == 0)) {
                break;
            }
            boolean isAdult = false;
            if (age > 17 || weight >= 80) {
                isAdult = true;
            }
            if (isAdult) {
                sb.append(name).append(" Senior").append('\n');
            } else {
                sb.append(name).append(" Junior").append('\n');
            }
        }
        System.out.println(sb);
    }
}