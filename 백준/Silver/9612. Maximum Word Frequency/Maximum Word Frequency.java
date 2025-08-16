import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
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
        
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        while (N-- > 0) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        List<String> list = new ArrayList<>(map.keySet());

        int max = Integer.MIN_VALUE;
        String maxKey = "";
        for (String str : list) {
            int temp = map.get(str);
            if (temp > max) {
                max = temp;
                maxKey = str;
            }
        }

        System.out.println(maxKey + " " + max);
    }
}