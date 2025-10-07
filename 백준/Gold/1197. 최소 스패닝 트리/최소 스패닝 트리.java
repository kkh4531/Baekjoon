import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int unf[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        unf = new int[v + 1];
        ArrayList<Edge> input = new ArrayList<>();
        for (int i = 1; i <= v; i++) unf[i] = i;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            input.add(new Edge(v1, v2, cost));
        }

        Collections.sort(input);
        int sum = 0;
        int cnt = 0;
        for (Edge edge : input) {
            int fv1 = find(edge.v1);
            int fv2 = find(edge.v2);
            if (fv1 != fv2) { // 현재 같은 트리가 아님.
                sum += edge.cost;
                Union(edge.v1, edge.v2); // 트리를 이음
                cnt++;
            }
            if (cnt == v - 1) break;
        }
        System.out.print(sum);
    }

    private static void Union(int a, int b) { // 트리를 이어줌
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    private static int find(int v) { // 같은 집합인지 확인 및 경로 응집
        if (v == unf[v]) return unf[v];
        else return unf[v] = find(unf[v]);
    }
}