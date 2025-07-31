import java.util.ArrayList;
// 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
import java.util.Scanner;

// 예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 
// 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int sum = A * B * C;
        String strSum = Integer.toString(sum);

        int hap[] = new int[10];

        for (int i = 0; i < strSum.length(); i++) {
            switch (strSum.charAt(i)) {
                case '0':
                    hap[0]++;
                    break;
                case '1':
                    hap[1]++;
                    break;
                case '2':
                    hap[2]++;
                    break;
                case '3':
                    hap[3]++;
                    break;
                case '4':
                    hap[4]++;
                    break;
                case '5':
                    hap[5]++;
                    break;
                case '6':
                    hap[6]++;
                    break;
                case '7':
                    hap[7]++;
                    break;
                case '8':
                    hap[8]++;
                    break;
                case '9':
                    hap[9]++;
                    break;

            }
        }
        for (int i = 0; i < hap.length; i++) {
            System.out.println(hap[i]);
        }
    }
}
