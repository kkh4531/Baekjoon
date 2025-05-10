import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    // 첫째 줄에 반에 있는 학생의 수 n이 주어진다. (1 ≤ n ≤ 100)

    // 다음 n개 줄에는 각 학생의 이름과 생일이 "이름 dd mm yyyy"와 같은 형식으로 주어진다. 이름은 그 학생의 이름이며, 최대
    // 15글자로 이루어져 있다. dd mm yyyy는 생일 일, 월, 연도이다. (1990 ≤ yyyy ≤ 2010, 1 ≤ mm ≤ 12, 1
    // ≤ dd ≤ 31) 주어지는 생일은 올바른 날짜이며, 연, 월 일은 0으로 시작하지 않는다.

    // 이름이 같거나, 생일이 같은 사람은 없다.

    // 출력
    // 첫째 줄에 가장 나이가 적은 사람의 이름, 둘째 줄에 가장 나이가 많은 사람 이름을 출력한다.

    // 예제 입력 1
    // 5
    // Mickey 1 10 1991
    // Alice 30 12 1990
    // Tom 15 8 1993
    // Jerry 18 9 1990
    // Garfield 20 9 1990
    // 예제 출력 1
    // Tom
    // Jerry
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Person person[] = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            person[i] = new Person(name, day, month, year);
        }
        Arrays.sort(person);

        System.out.println(person[0].getName());
        System.out.println(person[N - 1].getName());
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int day;
    private int month;
    private int year;

    Person(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    // 기본으로 year로 정렬
    // year가 같은 경우 month로 비교
    // Year month가 같으면 day로 비교
    @Override
    public int compareTo(Person o) {
        if (this.year == o.year) {
            if (this.month == o.month) {
                return o.day - this.day;
            }
            return o.month - this.month;
        }
        return o.year - this.year;
    }

}