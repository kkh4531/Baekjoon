import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(bufferedReader.readLine()); // 자료구조 개수

        int A[] = new int[N]; // 자료구조 형태 (queue or stack)
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()); //
        }

        int B[] = new int[N]; // 각 자료구조에 들어갈 첫 원소
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(bufferedReader.readLine()); // 삽입할 값 길이

        int C[] = new int[M]; // 삽입할 값들
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> queueStack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) { // 큐일 때만 값 관리
                queueStack.add(B[i]);
            }
        }

        for (int i = 0; i < M; i++) {
            queueStack.addFirst(C[i]);
            stringBuilder.append(queueStack.pollLast()).append(" ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }

}