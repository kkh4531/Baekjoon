import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        String names[] = new String[N];
        String temp = "";
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            temp += st.nextToken() + " ";
            temp += st.nextToken();
            names[i] = temp;
            temp = "";
        }
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1[] = o1.split(" ");
                String str2[] = o2.split(" ");
                if (str1[0].equals(str2[0])) {
                    return o2.compareTo(o1);
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : names) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }

}
