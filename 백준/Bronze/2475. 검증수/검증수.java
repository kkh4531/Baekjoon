import java.util.Scanner;

public class Main {
    // 문제
    // 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
    
    // 입력
    // 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
    
    // 출력
    // 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

    //     1071과 1029의 최대공약수를 구하면,

    // 1071은 1029로 나누어 떨어지지 않기 때문에, 1071을 1029로 나눈 나머지를 구한다. ≫ 42
    // 1029는 42로 나누어 떨어지지 않기 때문에, 1029를 42로 나눈 나머지를 구한다. ≫ 21
    // 42는 21로 나누어 떨어진다.
    // 따라서, 최대공약수는 21이다.
    public static int gCD(int a, int b) {
        return (b == 0) ? a : gCD(b, a % b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num[] = new int[5];

        int sum =0;
        for(int i=0; i<num.length; i++) {
            num[i] = scanner.nextInt();
            sum += num[i]*num[i];
        }
        System.out.println(sum%10);
    }
}
