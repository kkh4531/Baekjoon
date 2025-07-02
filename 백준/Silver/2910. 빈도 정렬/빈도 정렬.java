import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());

        List<Frequency> frequencyList = new ArrayList<>();
        int grade = 1;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            boolean flag = true;
            for (Frequency f : frequencyList) {
                if (tmp == f.getNum()) {
                    f.plusCnt();
                    flag = false;
                    break;
                }
            }
            if (flag) {
                frequencyList.add(new Frequency(tmp, grade++));
            }
        }

        Collections.sort(frequencyList);
        StringBuilder sb = new StringBuilder();
        for (Frequency f : frequencyList) {
            int size = f.getCnt();
            for (int i = 0; i < size; i++) {
                sb.append(f.getNum()).append(" ");
            }
        }
        System.out.print(sb);
    }
}

class Frequency implements Comparable<Frequency> {
    private int num;
    private int cnt;
    private int grade;

    Frequency(int num, int grade) {
        this.num = num;
        this.cnt = 1;
        this.grade = grade;
    }

    public int getNum() {
        return this.num;
    }

    public void plusCnt() {
        this.cnt++;
    }

    public int getCnt() {
        return this.cnt;
    }

    @Override
    public int compareTo(Frequency o) {
        if (this.cnt == o.cnt) return this.grade - o.grade;
        return o.cnt - this.cnt;
    }
}