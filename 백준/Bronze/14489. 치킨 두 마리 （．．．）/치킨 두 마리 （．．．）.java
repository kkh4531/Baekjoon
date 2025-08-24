import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(bufferedReader.readLine());

        int totalMoney = A + B;
        int chickenCost = 2 * C;

        if (totalMoney >= chickenCost) {
            System.out.println(totalMoney - chickenCost);
        } else {
            System.out.println(totalMoney);
        }
    }
}