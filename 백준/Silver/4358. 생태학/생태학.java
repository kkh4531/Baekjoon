import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>();
        int cnt = 0;
        String tmp;
        while ((tmp = bufferedReader.readLine()) != null) { // 계속 입력받다가 입력이 없으면 반복문 종료
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            cnt++;
        }
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(" ").append(String.format("%.4f", (double) (map.get(s) * 100) / cnt)).append(" ");
        }
        System.out.println(sb);
    }
}
