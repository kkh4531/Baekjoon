import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = N; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            if (i != 1) {
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}