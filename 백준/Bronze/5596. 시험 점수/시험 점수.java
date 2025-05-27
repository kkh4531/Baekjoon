import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sum1 = 0;
        for (int i = 0; i < 4; i++) {
            sum1 += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");

        int sum2 = 0;
        for (int i = 0; i < 4; i++) {
            sum2 += Integer.parseInt(st.nextToken());            
        }
        System.out.println(Math.max(sum1, sum2));
    }
}