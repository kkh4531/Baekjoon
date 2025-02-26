import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        boolean inTag = false; // 태그 안인지 확인하는 변수
        StringBuilder word = new StringBuilder(); // 단어를 저장할 StringBuilder

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '<') {
                // 태그가 시작되면 저장된 단어를 반전하여 추가
                if (word.length() > 0) {
                    sb.append(word.reverse());
                    word.setLength(0); // 단어 초기화
                }
                inTag = true; // 태그 안으로 들어감
                sb.append(c); // 태그 시작 추가
            } else if (c == '>') {
                inTag = false; // 태그가 끝남
                sb.append(c); // 태그 끝 추가
            } else if (inTag) {
                sb.append(c); // 태그 안의 문자 추가
            } else {
                if (c == ' ') {
                    // 공백을 만나면 저장된 단어를 반전하여 추가
                    if (word.length() > 0) {
                        sb.append(word.reverse());
                        word.setLength(0); // 단어 초기화
                    }
                    sb.append(c); // 공백 추가
                } else {
                    word.append(c); // 단어에 문자 추가
                }
            }
        }

        // 마지막에 남은 단어가 있다면 반전하여 추가
        if (word.length() > 0) {
            sb.append(word.reverse());
        }

        System.out.println(sb);
    }

}
