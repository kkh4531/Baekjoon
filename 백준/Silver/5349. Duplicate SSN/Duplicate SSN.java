import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> set = new HashSet<>();

        String input = "";
        List<String> list = new ArrayList<>();
        while (true) {
            input = bufferedReader.readLine();
            if (input.equals("000-00-0000")) break;
            else {
                if (!set.add(input) && !list.contains(input)) list.add(input);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str).append('\n');
        }
        System.out.print(sb);
    }
}