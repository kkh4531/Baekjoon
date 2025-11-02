import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int month = Integer.parseInt(bufferedReader.readLine());
        int day = Integer.parseInt(bufferedReader.readLine());

        if (month < 2) System.out.println("Before");
        else if (month > 2) System.out.println("After");
        else {
            if (day == 18) System.out.println("Special");
            else if (day < 18) System.out.println("Before");
            else System.out.println("After");
        }

    }
}