import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fullString = bufferedReader.readLine(); 

        char[] ucpc = {'U', 'C', 'P', 'C'};
        int currentSearchIndex = 0;

        for (int i = 0; i < 4; i++) {
            char targetChar = ucpc[i];
            
            int foundIndex = fullString.indexOf(targetChar, currentSearchIndex);

            if (foundIndex == -1) {
                System.out.print("I hate UCPC");
                return;
            } else {
                currentSearchIndex = foundIndex + 1; 
            }
        }
        System.out.print("I love UCPC");
    }
}
