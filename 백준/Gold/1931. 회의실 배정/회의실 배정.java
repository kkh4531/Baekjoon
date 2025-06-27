import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Time> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Time(start, end));
        }

        System.out.print(solution(list));
    }

    public static int solution(ArrayList<Time> times) {
        Collections.sort(times);
        int cnt = 0;
        int ep = 0;
        for (Time t : times) {
            if (t.getStartTime() >= ep) {
                ep = t.getEndTime();
                cnt++;
            }
        }
        return cnt;
    }
}

class Time implements Comparable<Time> {
    private int startTime;
    private int endTime;

    Time(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    @Override
    public int compareTo(Time o) {
        if (this.endTime == o.endTime) return this.startTime - o.startTime;
        return this.endTime - o.endTime;
    }
}