import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int graph[][];
    static int root;
    static boolean delete[];
    static boolean flag;
    static int n;
    static int x;

    public static void dfs(int cv, int parentNode) {
        if (cv == x) { // 지울 노드이면
            if (cv == root) { // 지울 노드가 root 노드이면
                for (int i = 0; i < n; i++) { // 어차피 모든 노드들은 지워지니깐 모두 true
                    delete[i] = true;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        graph[i][j] = 0;
                    }
                } // 어차피 첫 노드부터 바로 찾은 거니까 flag를 따로 할당해 줄 필요없음.
            } else { // 지우려는 노드가 루트 노드가 아니면
                graph[parentNode][cv] = 0;
                delete[cv] = true;
                flag = true;
                for (int i = 0; i < n; i++) {
                    if (graph[cv][i] == 1) {
                        //graph[cv][i] = 0; //
                        //delete[i] = true; //
                        dfs(i, cv);
                    }
                }
                flag = false;
            }
        } else if (flag) {
            graph[parentNode][cv] = 0;
            delete[cv] = true;
            for (int i = 0; i < n; i++) {
                if (graph[cv][i] == 1) {
                    //graph[cv][i] = 0; //
                    //delete[cv] = true; //
                    dfs(i, cv);
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (graph[cv][i] == 1) {
                    dfs(i, cv);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        graph = new int[n][n];
        delete = new boolean[n];

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) { // i는 자식
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == -1) {
                root = i;
            } else {
                graph[tmp][i] = 1;
            }
        }
        x = Integer.parseInt(bufferedReader.readLine());

        dfs(root, -1);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!delete[i]) { // 일단 삭제되지 않았고
                boolean flag = false;
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 1) { // 하나라도 자식이 달려있다면 리프노드 아님
                        flag = true;
                    }
                }
                if (!flag) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}