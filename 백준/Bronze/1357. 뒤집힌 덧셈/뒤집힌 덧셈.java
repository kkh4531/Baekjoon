import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Main {
//     어떤 수 X가 주어졌을 때, X의 모든 자리수가 역순이 된 수를 얻을 수 있다. Rev(X)를 X의 모든 자리수를 역순으로 만드는 함수라고 하자. 
// 예를 들어, X=123일 때, Rev(X) = 321이다. 그리고, X=100일 때, Rev(X) = 1이다.

// 두 양의 정수 X와 Y가 주어졌을 때, Rev(Rev(X) + Rev(Y))를 구하는 프로그램을 작성하시오

// 입력
// 첫째 줄에 수 X와 Y가 주어진다. X와 Y는 1,000보다 작거나 같은 자연수이다.

// 출력
// 첫째 줄에 문제의 정답을 출력한다.

// 예제 입력 1 
// 123 100
// 예제 출력 1 
// 223
// 예제 입력 2 
// 111 111
// 예제 출력 2 
// 222
// 예제 입력 3 
// 5 5
// 예제 출력 3 
// 1
// 예제 입력 4 
// 1000 1
// 예제 출력 4 
// 2
// 예제 입력 5 
// 456 789
// 예제 출력 5 
// 1461
    public static int reverse(int n) {
        int reverse = 0;
        while(n!=0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n /= 10;
        }
        return reverse;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input[] = reader.readLine().split(" ");
        int X = Integer.parseInt(input[0]);
        int Y = Integer.parseInt(input[1]);

        int Xreverse = reverse(X);
        int Yreverse = reverse(Y);

        int sumReverse = Xreverse + Yreverse;

        int sumReReverse = reverse(sumReverse);

        System.out.println(sumReReverse);
    }
}
