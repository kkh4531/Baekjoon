import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
