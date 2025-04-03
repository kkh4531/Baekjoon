import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dna = bufferedReader.readLine();
        st = new StringTokenizer(bufferedReader.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        char acgt[] = {'A', 'C', 'G', 'T'};
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(acgt[i], 0);
        }

        for (int i = 0; i < p; i++) {
            map.put(dna.charAt(i), map.get(dna.charAt(i)) + 1);
        }
        int cnt = 0;
        if (check(map, a, c, g, t)) {
            cnt++;
        }
        int lt = 0;
        for (int i = p; i < s; i++) {
            map.put(dna.charAt(i), map.get(dna.charAt(i)) + 1);
            map.put(dna.charAt(lt), map.get(dna.charAt(lt)) - 1);
            if (check(map, a, c, g, t)) {
                cnt++;
            }
            lt++;
        }
        System.out.println(cnt);
    }

    public static boolean check(HashMap<Character, Integer> map, int a, int c, int g, int t) {
        return map.get('A') >= a && map.get('C') >= c && map.get('G') >= g && map.get('T') >= t;
    }
}
