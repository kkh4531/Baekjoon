import java.util.Scanner;

public class Main {
    public static long hashFunction(char c[]) {
        long sum = 0;
        long mod = 1234567891;
        long power = 1; // 31의 거듭제곱값

        for (int i = 0; i < c.length; i++) {
            long temp = (int)(c[i] - 'a' + 1); // 'a'는 1, 'b'는 2, ..., 'z'는 26
            sum = (sum + temp * power) % mod; // 현재 해시값에 추가
            power = (power * 31) % mod; // 다음 거듭제곱 계산
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt(); // 문자열의 길이
        String str = scanner.next(); // 문자열 입력
        char c[] = str.toCharArray(); // 문자열을 문자 배열로 변환

        System.out.println(hashFunction(c)); // 해시값 출력
    }
}
