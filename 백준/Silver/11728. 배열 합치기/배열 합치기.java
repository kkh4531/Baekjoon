import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String splits[] = bufferedReader.readLine().split(" ");

        int res[] = new int[Integer.parseInt(splits[0]) + Integer.parseInt(splits[1])];

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < Integer.parseInt(splits[0]); i++) {
            res[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = Integer.parseInt(splits[0]); i < Integer.parseInt(splits[0]) + Integer.parseInt(splits[1]); i++) {
            res[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(res);
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

}
