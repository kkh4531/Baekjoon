import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Main {
    // 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는
    // 프로그램을 작성하시오.

    // 입력
    // 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
    // (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

    // 출력
    // 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

    // 예제 입력 1 
    // 5
    // 0 4
    // 1 2
    // 1 -1
    // 2 2
    // 3 3
    // 예제 출력 1 
    // 1 -1
    // 1 2
    // 2 2
    // 3 3
    // 0 4
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        Coordinate c[] = new Coordinate[N];
        for (int i = 0; i < N; i++) {
            String input[] = reader.readLine().split(" ");
            c[i] = new Coordinate(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        Arrays.sort(c);
        
        for (int i = 0; i < N; i++) {
            sb.append(c[i].getX()).append(" ").append(c[i].getY()).append('\n');
        }
        System.out.println(sb);
    }
}

class Coordinate implements Comparable<Coordinate> {
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public int compareTo(Coordinate o) {
        if (this.y == o.y) {
            return this.x - o.x;
        }
        return this.y - o.y;
    }
}
