import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        String X = st.nextToken();
        String Y = st.nextToken();

        System.out.print(solution(X, Y));
    }

    public static String solution(String X, String Y) {
        String answer = "";
        int arrX[] = new int[10];
        int arrY[] = new int[10];

        for (int i = 0; i < X.length(); i++) {
            int now = Character.getNumericValue(X.charAt(i));
            arrX[now]++;
        }

        for (int i = 0; i < Y.length(); i++) {
            int now = Character.getNumericValue(Y.charAt(i));
            arrY[now]++;
        }

        ArrayList<Character> list = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            int min = Math.min(arrX[i], arrY[i]);
            if (min != 0) {
                flag = true;
                for (int j = 0; j < min; j++) {
                    list.add(String.valueOf(i).charAt(0));
                }
            }
        }

        if (!flag) return "-1";
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        answer = sb.toString();
        if (answer.charAt(0) == '0') return "0";
        return answer;
    }
}