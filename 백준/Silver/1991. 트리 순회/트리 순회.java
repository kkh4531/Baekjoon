import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static HashMap<Character, char[]> map;
    static int n;
    static StringBuilder sb;

    public static void dfs(char c, int way) {
        if (way == 0) { // 전위
            sb.append(c);
            char tmp[] = map.get(c);
            char left = tmp[0];
            char right = tmp[1];
            if (left != '.') dfs(left, way);
            if (right != '.') dfs(right, way);
        } else if (way == 1) { // 중위
            char tmp[] = map.get(c);
            char left = tmp[0];
            char right = tmp[1];
            if (left != '.') dfs(left, way);
            sb.append(c);
            if (right != '.') dfs(right, way);
        } else { // 후위
            char tmp[] = map.get(c);
            char left = tmp[0];
            char right = tmp[1];
            if (left != '.') dfs(left, way);
            if (right != '.') dfs(right, way);
            sb.append(c);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        map = new HashMap<>();
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String input[] = bufferedReader.readLine().split(" ");
            char root = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            map.put(root, new char[]{left, right});
        }

        for (int i = 0; i < 3; i++) {
            dfs('A', i);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}