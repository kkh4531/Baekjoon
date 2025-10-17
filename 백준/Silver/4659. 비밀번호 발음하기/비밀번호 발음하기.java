import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Set<Character> jaum = new HashSet<>();
        for (int i = 97; i < 123; i++) {
            if (!(i == 97 || i == 101 || i == 105 || i == 111 || i == 117)) {//모음이 아니면
                jaum.add((char) i);
            }
        }
        Set<Character> moum = new HashSet<>();
        moum.add('a');
        moum.add('e');
        moum.add('i');
        moum.add('o');
        moum.add('u');
        String s = "";
        StringBuilder sb = new StringBuilder();
        while (true) {
            s = bufferedReader.readLine();
            if (s.equals("end")) break;
            boolean flag = false;
            boolean res = false;
            for (int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                if (moum.contains(tmp)) {
                    flag = true;
                }
            }
            if (!flag) {
                sb.append("<").append(s).append(">").append(" is not acceptable.").append('\n');
                continue;
            }
            int cntJaum = 0;
            int cntMoum = 0;
            for (int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                if (jaum.contains(tmp)) {
                    cntJaum++;
                    cntMoum = 0;
                    if (cntJaum == 3) {
                        res = true;
                        break;
                    }
                } else {
                    cntMoum++;
                    cntJaum = 0;
                    if (cntMoum == 3) {
                        res = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < s.length() - 1; i++) {
                char tmp1 = s.charAt(i);
                char tmp2 = s.charAt(i + 1);
                if (tmp1 == tmp2 && !(tmp1 == 'e' || tmp1 == 'o')) {
                    res = true;
                    break;
                }
            }
            if (res) sb.append("<").append(s).append(">").append(" is not acceptable.").append('\n');
            else sb.append("<").append(s).append(">").append(" is acceptable.").append('\n');
        }
        System.out.print(sb);
    }
}