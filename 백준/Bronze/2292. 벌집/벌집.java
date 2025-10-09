import java.util.Scanner;

public class Main {
//     1 - 1
// 2 ~ 7 - 2
// 8 ~ 19 - 3
// 20 ~ 37 - 4
// 38 ~ 61 - 5
// 62 ~ 70….- 6

// 5 11 17 23 29
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int result = 2;
        int range = 8;
        if(n==1) {
            result = 1;
        } else if(n >= 2 && n <= 7) {
            result = 2;
        } else {
            while(range <= n) {
                range = range + (6*result);
                result++;
            }
        }


        System.out.println(result);
    }
}
