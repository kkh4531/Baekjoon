import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        String arr[] = bufferedReader.readLine().split(" ");
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            if (arr[i].endsWith("Cheese")) {
                set.add(arr[i]);
            }
        }
        if (set.size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }

}
