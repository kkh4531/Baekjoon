import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String key = bufferedReader.readLine(); // key
        String secretStr = bufferedReader.readLine();
        char secretStrToChar[][] = new char[secretStr.length() / key.length()][key.length()];
        int k = 0;
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < secretStr.length() / key.length(); j++) {
                secretStrToChar[j][i] = secretStr.charAt(k++);
            }
        }

        char c[] = key.toCharArray();
        Arrays.sort(c);
        String keySort = new String(c); // key를 정렬한 것
        HashMap<Character, List<String>> map = new HashMap<>();

        for (int i = key.length() - 1; i >= 0; i--) { // 열
            String temp = "";
            for (int j = 0; j < secretStr.length() / key.length(); j++) { // 행
                temp += secretStrToChar[j][i];
            }
            if (map.containsKey(keySort.charAt(i))) { // HashMap에 keySort의 마지막부터 시작했는데 이미 있었다면
                List<String> tempList = map.get(keySort.charAt(i));
                tempList.add(temp);
                map.put(keySort.charAt(i), tempList);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(temp);
                map.put(keySort.charAt(i), tempList);
            }
        }
        char result[][] = new char[secretStr.length() / key.length()][key.length()];
        for (int i = 0; i < key.length(); i++) {
            char tempChar = key.charAt(i);
            int size = map.get(tempChar).size() - 1;
            List<String> tempList = map.get(tempChar);
            String tempStr = map.get(tempChar).get(size);
            tempList.remove(size);
            map.put(tempChar, tempList);
            for (int j = 0; j < secretStr.length() / key.length(); j++) {
                result[j][i] = tempStr.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < secretStr.length() / key.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                sb.append(result[i][j]);
            }
        }
        System.out.println(sb);
    }

}
