import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        
        BigInteger A = new BigInteger(bufferedReader.readLine());
        BigInteger B = new BigInteger(bufferedReader.readLine());

        stringBuilder.append(A.add(B)).append('\n');  // A + B
        stringBuilder.append(A.subtract(B)).append('\n');  // A - B
        stringBuilder.append(A.multiply(B));  // A * B

        System.out.println(stringBuilder);
    }
}
