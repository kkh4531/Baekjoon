import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int n;
    static ArrayList<ArrayList<Integer>> result;

    public static void dfs(int[] nodes, int level) {
        if (nodes.length == 3) {
            result.get(level).add(nodes[1]);
            result.get(level + 1).add(nodes[0]);
            result.get(level + 1).add(nodes[2]);
        } else {
            int mid = nodes.length / 2;
            result.get(level).add(nodes[mid]);
            int[] left = Arrays.copyOfRange(nodes, 0, mid);
            int[] right = Arrays.copyOfRange(nodes, mid + 1, nodes.length);
            dfs(left, level + 1);
            dfs(right, level + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        int size = (int) Math.pow(2, n) - 1;
        result = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            result.add(new ArrayList<>());
        }

        int[] init = new int[size];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < size; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }

        dfs(init, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            ArrayList<Integer> tmp = result.get(i);
            for (int j : tmp) {
                sb.append(j).append(" ");
            }
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}