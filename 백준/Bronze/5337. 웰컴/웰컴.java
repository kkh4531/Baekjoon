import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        sb.append(".  .   .").append('\n');
        sb.append("|  | _ | _. _ ._ _  _").append('\n');
        sb.append("|/\\|(/.|(_.(_)[ | )(/.");
        System.out.println(sb);
    }
}