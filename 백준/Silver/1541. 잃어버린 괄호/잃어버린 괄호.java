import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String split[] = bufferedReader.readLine().split("-");
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            String tmp[] = split[i].split("\\+");
            int tmpInt = 0;
            for (int j = 0; j < tmp.length; j++) {
                tmpInt += Integer.parseInt(tmp[j]);
            }
            if (i == 0) {
                sum = tmpInt;
            } else {
                sum -= tmpInt;
            }
        }
        System.out.println(sum);
    }
}
