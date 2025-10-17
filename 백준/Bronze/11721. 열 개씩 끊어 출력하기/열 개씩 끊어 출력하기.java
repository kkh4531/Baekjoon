import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        StringBuilder sb = new StringBuilder();

        sb.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            sb.append(input.charAt(i));
            if ((i + 1) % 10 == 0) sb.append('\n');
        }
        System.out.print(sb);
    }
}