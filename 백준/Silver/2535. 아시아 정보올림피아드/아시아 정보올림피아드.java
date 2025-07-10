import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int countryMax = 0;
        LinkedList<Info> info = new LinkedList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int country = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            countryMax = Math.max(countryMax, country);
            info.add(new Info(country, num, score));
        }
        int countryArr[] = new int[countryMax + 1];
        Collections.sort(info);
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < 3) {
            Info tmp = info.getFirst();
            if (countryArr[tmp.getCountry()] < 2) {
                countryArr[tmp.getCountry()]++;
                sb.append(tmp.getCountry()).append(" ").append(tmp.getNumber()).append('\n');
                idx++;
            }
            info.removeFirst();
        }

        System.out.print(sb);
    }
}

class Info implements Comparable<Info> {
    private int country;
    private int number;
    private int score;

    public Info(int country, int number, int score) {
        this.country = country;
        this.number = number;
        this.score = score;
    }

    public int getCountry() {
        return this.country;
    }

    public int getNumber() {
        return this.number;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Info o) {
        return o.score - this.score;
    }
}