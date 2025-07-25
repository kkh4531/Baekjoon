import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class Coordinate implements Comparable<Coordinate> {
    public int vertex;
    public int cost;

    public Coordinate(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Coordinate o) {
        return this.cost - o.cost;
    }
}

public class Main {

    static ArrayList<ArrayList<Coordinate>> graph;
    static int dis[];

    public static void dijikstra() {
        PriorityQueue<Coordinate> priorityQueue = new PriorityQueue<>();
        dis[1] = 0;
        priorityQueue.offer(new Coordinate(1, 0));
        while (!priorityQueue.isEmpty()) {
            Coordinate tmp = priorityQueue.poll();
            int nowVertex = tmp.vertex;
            int nowCost = tmp.cost;
            if (nowCost > dis[nowVertex]) continue;
            for (Coordinate c : graph.get(nowVertex)) {
                if (dis[c.vertex] > nowCost + c.cost) {
                    dis[c.vertex] = nowCost + c.cost;
                    priorityQueue.offer(new Coordinate(c.vertex, nowCost + c.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        BigInteger num1 = new BigInteger(st.nextToken());
        BigInteger num2 = new BigInteger(st.nextToken());

        System.out.print(num1.multiply(num2));
//        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        graph = new ArrayList<>();
//        dis = new int[n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            dis[i] = Integer.MAX_VALUE;
//        }
//        for (int i = 0; i <= n; i++) {
//            graph.add(new ArrayList<>());
//        }
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(bufferedReader.readLine());
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//            int cost = Integer.parseInt(st.nextToken());
//            graph.get(from).add(new Coordinate(to, cost));
//        }
//
//        dijikstra();
//        for (int i : dis) {
//            System.out.println(i + " ");
//        }
    }
}