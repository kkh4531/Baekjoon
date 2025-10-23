import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(bufferedReader.readLine()));
        }
        Collections.sort(list, Collections.reverseOrder());
        long sum = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int tmp = list.get(i) - i;
            if (!(tmp <= 0)) {
                sum += tmp;
            }
        }
        System.out.print(sum);
    }
}