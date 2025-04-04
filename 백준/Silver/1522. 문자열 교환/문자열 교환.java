import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int aSize = 0;
        for (int i = 0; i < str.length(); i++) { // 연속된 a가 몇개여야 하는지 구함
            if (str.charAt(i) == 'a') {
                aSize++;
            }
        }
        int aCnt = 0;
        int bCnt = 0;
        for (int i = 0; i < aSize; i++) {
            if (str.charAt(i) == 'a') {
                aCnt++;
            } else {
                bCnt++;
            }
        }
        int min = bCnt;
        int lt = 0;
        for (int rt = aSize; rt < str.length(); rt++) {
            if (str.charAt(lt++) == 'a') {
                aCnt--;
            } else {
                bCnt--;
            }
            if (str.charAt(rt) == 'a') {
                aCnt++;
            } else {
                bCnt++;
            }
            if (min > bCnt) {
                min = bCnt;
            }
        }

        for (int rt = 0; rt < aSize - 1; rt++) { // 끝 인덱스를 맞이했으면 이어서 시작
            if (str.charAt(lt++) == 'a') {
                aCnt--;
            } else {
                bCnt--;
            }
            if (str.charAt(rt) == 'a') {
                aCnt++;
            } else {
                bCnt++;
            }
            if (min > bCnt) {
                min = bCnt;
            }
        }
        System.out.println(min);
    }
}
