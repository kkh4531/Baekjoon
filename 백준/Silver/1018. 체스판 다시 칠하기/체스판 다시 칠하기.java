import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    // 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고,
    // 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.

    // 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두
    // 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이
    // 흰색인 경우, 하나는 검은색인 경우이다.

    // 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고
    // 생각했다. 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

    // 입력
    // 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각
    // 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

    // 출력
    // 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.

    // 예제 입력 1
    // 8 8
    // WBWBWBWB
    // BWBWBWBW
    // WBWBWBWB
    // BWBBBWBW
    // WBWBWBWB
    // BWBWBWBW
    // WBWBWBWB
    // BWBWBWBW
    // 예제 출력 1
    // 1
    // 예제 입력 2
    // 10 13
    // BBBBBBBBWBWBW
    // BBBBBBBBBWBWB
    // BBBBBBBBWBWBW
    // BBBBBBBBBWBWB
    // BBBBBBBBWBWBW
    // BBBBBBBBBWBWB
    // BBBBBBBBWBWBW
    // BBBBBBBBBWBWB
    // WWWWWWWWWWBWB
    // WWWWWWWWWWBWB
    // 예제 출력 2
    // 12

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가로
        int M = Integer.parseInt(st.nextToken()); // 세로

        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    board[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static boolean board[][];
    public static int min = 64;

    public static void find(int startrow, int startcol) {
        int cnt = 0;
        boolean init = board[startrow][startcol];
        for (int i = startrow; i < startrow + 8; i++) {
            for (int j = startcol; j < startcol + 8; j++) {
                if (board[i][j] != init) {
                    cnt++;
                }
                init = (!init);
            }
            init = (!init);
        }
        cnt = Math.min(cnt, 64 - cnt);
        min = Math.min(min, cnt);
    }
}