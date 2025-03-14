import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;
        String result = "";
        while (flag) {
            String arr[] = bufferedReader.readLine().trim().split(" ");
            for (int i = 0; i < arr.length; i++) {
                String temp = arr[i].replaceAll("[^a-zA-Z-]", "");
                if (temp.equals("E-N-D")) {
                    flag = false;
                    break;
                }
                if (temp.length() > result.length()) {
                    result = temp;
                }
            }
        }
        System.out.println(result.toLowerCase());
    }

}
