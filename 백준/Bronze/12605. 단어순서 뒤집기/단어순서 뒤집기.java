import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int temp = stringTokenizer.countTokens();
            for (int j = 0; j < temp; j++) {
                stack.push(stringTokenizer.nextToken());
            }
            stringBuilder.append("Case #").append(i + 1).append(": ");
            for (int j = 0; j < temp; j++) {
                stringBuilder.append(stack.pop()).append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }
}