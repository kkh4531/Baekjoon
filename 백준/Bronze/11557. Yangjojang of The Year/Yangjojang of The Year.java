import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer;
            TreeMap<Integer, String> map = new TreeMap<>();
            for (int j = 0; j < N; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String university = stringTokenizer.nextToken();
                Integer sul = Integer.parseInt(stringTokenizer.nextToken());
                map.put(sul, university);
            }
            stringBuilder.append(map.get(map.lastKey())).append('\n');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }

}