import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        BigInteger A = new BigInteger(a);
        String b = scanner.next();
        BigInteger B = new BigInteger(b);

        System.out.println(A.add(B));
    }
}
