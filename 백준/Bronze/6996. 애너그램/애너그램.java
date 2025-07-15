import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(bufferedReader.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            if (solution(first, second)) {
                sb.append(first).append(" ").append("&").append(" ").append(second).append(" are").append(" anagrams.").append('\n');
            } else {
                sb.append(first).append(" ").append("&").append(" ").append(second).append(" ").append("are NOT").append(" ").append("anagrams.").append('\n');
            }
        }
        System.out.print(sb);
    }

    public static boolean solution(String first, String second) {
        char f[] = first.toCharArray();
        char s[] = second.toCharArray();
        Arrays.sort(f);
        Arrays.sort(s);
        if (f.length != s.length) return false;
        for (int i = 0; i < f.length; i++) {
            if (f[i] != s[i]) return false;
        }
        return true;
    }
}