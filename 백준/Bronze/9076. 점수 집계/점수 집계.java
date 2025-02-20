import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        LinkedList<Integer> list;
        while (T-- > 0) {
            st = new StringTokenizer(bufferedReader.readLine());
            list = new LinkedList<>();
            int size = st.countTokens();
            for (int i = 0; i < size; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            list.removeFirst();
            list.removeLast();
            if ((list.getLast() - list.getFirst()) >= 4) {
                sb.append("KIN").append('\n');
            } else {
                int total = 0;
                for (int i = 0; i < 3; i++) {
                    total += list.get(i);
                }
                sb.append(total).append('\n');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

}
