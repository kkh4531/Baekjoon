import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {

        int v1;
        int v2;
        double cost;

        public Edge(int v1, int v2, double cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    static int unf[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n  = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer st;
        double arr[][] = new double[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            double d1 = Double.parseDouble(st.nextToken());
            double d2 = Double.parseDouble(st.nextToken());
            arr[i][0] = d1;
            arr[i][1] = d2;
        }

        ArrayList<Edge> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                list.add(new Edge(i, j, calculateDistance(arr[i][0], arr[i][1], arr[j][0], arr[j][1])));
            }
        }
        Collections.sort(list);
        unf = new int[n];
        for (int i = 0; i < n; i++) unf[i] = i;
        double sum = 0;

        for (Edge e : list) {
            int fv1 = find(e.v1);
            int fv2 = find(e.v2);
            if (fv1 != fv2) {
                union(fv1, fv2);
                sum += e.cost;
            }
        }
        System.out.printf("%.2f", sum);
    }

    public static int find(int v) {
        if (unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int v1, int v2) {
        unf[v1] = v2;
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}