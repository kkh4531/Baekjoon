import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String a = bufferedReader.readLine();
        BigInteger A = new BigInteger(a);
        String str = bufferedReader.readLine();
        String b = bufferedReader.readLine();
        BigInteger B = new BigInteger(b);

        BigInteger result;
        if (str.equals("*")) {
            result = A.multiply(B);
        } else {
            result = A.add(B);
        }

        System.out.println(result);
    }

}
