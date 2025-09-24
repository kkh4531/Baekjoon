import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sixPrice = Integer.MAX_VALUE;
        int uniPrice = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            if (tmp < sixPrice) sixPrice = tmp;
            if (tmp2 < uniPrice) uniPrice = tmp2;
        }

        int res = 0;
        if (n >= 6){
            int first = (n / 6) * sixPrice;
            int second = (n % 6) * uniPrice;
            if (second > sixPrice) second = sixPrice;
            res = Math.min(first + second, n * uniPrice);
        } 
        else { // 6개 미만일 때 낱개미만으로 사는 것보다 패키지 하나를 사는 게 쌀 경우랑 비교해야함
            res = Math.min(n * uniPrice, sixPrice);
        }

        System.out.print(res);
    }
}