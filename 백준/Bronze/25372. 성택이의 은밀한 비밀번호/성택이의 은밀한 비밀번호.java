import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        //String str[] = new String[n];
        
        //StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String num = reader.readLine();
            if(num.length() >= 6 && num.length() <= 9) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
