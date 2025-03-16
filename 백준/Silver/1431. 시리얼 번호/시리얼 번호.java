import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String arr[] = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = bufferedReader.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return Integer.compare(o1.length(), o2.length());
                } else if (o1.length() == o2.length()) {
                   if (sum(o1) != sum(o2)) {
                       return sum(o1) - sum(o2);
                   }
                }
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }

    public static int sum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sum += Character.getNumericValue(s.charAt(i));
            }
        }
        return sum;
    }

}
