import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            String title = st.nextToken();
            int capability = Integer.parseInt(st.nextToken());
            if (map.get(capability) == null) {
                ArrayList<String> list = new ArrayList<>();
                list.add(title);
                map.put(capability, list);
            } else {
                ArrayList<String> list = map.get(capability);
                list.add(title);
                map.put(capability, list);
            }
        }
        int arr[] = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        StringBuilder sb = new StringBuilder();
        int temp[] = new int[map.size()];
        int idx = 0;
        for (int i : map.keySet()) {
            temp[idx++] = i;
        }
        Arrays.sort(temp);
        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(arr[i], temp)).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static HashMap<Integer, ArrayList<String>> map = new HashMap<>();

    public static String binarySearch(int t, int arr[]) {
        String result = "";
        if (t <= arr[0]) {
            return map.get(arr[0]).get(0);
        }
        int rt = arr.length - 1;
        int lt = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] >= t) {
                result = map.get(arr[mid]).get(0);
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return result;
    }
}
