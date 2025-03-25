import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        String postfix = bufferedReader.readLine();
        HashMap<Character, Double> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            double temp = Integer.parseInt(bufferedReader.readLine());
            map.put((char) (65 + i), temp);
        }
        Deque<Double> dq = new ArrayDeque<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isAlphabetic(c)) { // 알파벳일 경우 = 숫자일 경우
                dq.addLast(map.get(c));
            } else { // 연산자일 경우
                double second = dq.pollLast();
                double first = dq.pollLast();
                double tempResult = 0;
                switch (c) {
                    case '*' :
                        tempResult = first * second; break;
                    case '+' :
                        tempResult = first + second; break;
                    case '-' :
                        tempResult = first - second; break;
                    case '/' :
                        tempResult = first / second; break;
                }
                dq.addLast(tempResult);
            }
        }
        System.out.printf("%.2f", dq.poll());
    }

}
