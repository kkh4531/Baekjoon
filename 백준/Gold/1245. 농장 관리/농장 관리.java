import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int [][] matrix;
    static boolean[][] visited;
    static int nOfTop;
    static Position[] deltas = {
            new Position(-1,-1),
            new Position(-1,0),
            new Position(-1,1),
            new Position(0,-1),
            new Position(0,1),
            new Position(1,-1),
            new Position(1,0),
            new Position(1,1),
    };

    static int n,m;
    static Queue<Position> q;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        visited = new boolean[n][m];
        q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                if(bfs(i,j))
                    nOfTop++;
            }
        }

        System.out.println(nOfTop);


    }

    static boolean bfs(int row, int col){
        q.add(new Position(row, col));
        int height = matrix[row][col];
        visited[row][col] = true;
        boolean isTop = true;

        while (!q.isEmpty()) {
            Position pos = q.poll();

            for (Position del : deltas) {
                int nr = pos.row + del.row;
                int nc = pos.col + del.col;
                if (isIn(nr, nc)) {
                    if (matrix[nr][nc] > height) {
                        isTop = false;
                    }else{
                        if (!visited[nr][nc] && matrix[nr][nc] == height) {
                            visited[nr][nc] = true;
                            q.add(new Position(nr,nc));
                        }
                    }
                }
            }
        }
        return isTop;
    }

    static boolean isIn(int row, int col){
        return row >= 0 && row <n && col >= 0 && col < m;
    }

    static class Position{
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


}