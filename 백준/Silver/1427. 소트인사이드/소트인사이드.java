import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Main {
    // 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

    // 입력
    // 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

    // 출력
    // 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

    // 예제 입력 1
    // 2143
    // 예제 출력 1
    // 4321
    // 예제 입력 2
    // 999998999
    // 예제 출력 2
    // 999999998
    // 예제 입력 3
    // 61423
    // 예제 출력 3
    // 64321
    // 예제 입력 4
    // 500613009
    // 예제 출력 4
    // 965310000
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input[] = reader.readLine().split("");

        int nums[] = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        for (int key : nums) {
            System.out.print(key);
        }
    }
}
