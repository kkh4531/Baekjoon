import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());

        int cnt = 0;
        for (int i = 0; i < t; i++) {
            String input = bufferedReader.readLine();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            stack.push(input.charAt(0));
            for (int j = 1; j <= input.length() - 1; j++) {
                char tmp = input.charAt(j);
                if (stack.isEmpty()) stack.push(tmp);
                else if (tmp == stack.peek()) stack.pop();
                else stack.push(tmp);
            }
            if (stack.isEmpty()) cnt++;
        }
        System.out.print(cnt);
    }
}