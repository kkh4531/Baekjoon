import java.util.Scanner;

// 문제
// 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

// 예제 입력 1 
// 4
// 1 3 5 7

// 예제 출력 1 
// 3
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            int count = 0;
            for (int j = 2; j <= arr[i]; j++) {
                if (arr[i] % j == 0) {
                    count++;
                }
            }
            if (count == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
