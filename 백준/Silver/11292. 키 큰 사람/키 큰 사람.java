import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n == 0) {
                break;
            }
            Person person[] = new Person[n];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bufferedReader.readLine());
                person[i] = new Person(st.nextToken(), Double.parseDouble(st.nextToken()));
            }
            Arrays.sort(person);
            Person tallest = person[0];
            sb.append(tallest.getName());
            for (int i = 1; i < n; i++) {
                if (person[i].getHeight() < tallest.getHeight()) break;
                sb.append(" ").append(person[i].getName());
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

class Person implements Comparable<Person> {
    private String name;
    private double height;


    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public Person(String name, double height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public int compareTo(Person o) {
        return Double.compare(o.height, this.height);
    }
}