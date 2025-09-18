import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t  = Integer.parseInt(bufferedReader.readLine());

        if (t % 10 != 0) {
            System.out.println(-1);
            return;
        }
        int arr[] = new int[3];

        arr[0] = t / 300;
        t = t % 300;
        arr[1] = t / 60;
        t = t % 60;
        arr[2] = t / 10;
        System.out.print(arr[0] + " " + arr[1] + " " + arr[2]);
    }
}