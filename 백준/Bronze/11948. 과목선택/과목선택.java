import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arr[] = new int[4];
        int arr2[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(arr);
        Arrays.sort(arr2);
        System.out.println(arr[3] + arr[2] + arr[1] + arr2[1]);
    }
}