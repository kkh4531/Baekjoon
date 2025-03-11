import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            int box = M;
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if (box - temp < 0) {
                    box = M;
                    cnt++;
                }
                box -= temp;
            }
            cnt += 1;
        }
        System.out.println(cnt);
    }
}