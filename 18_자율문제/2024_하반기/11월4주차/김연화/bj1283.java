import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isCheck = new boolean[26];

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < n; t++) {
            String option = br.readLine();
            String str = findRepresentativeKey(option, isCheck);

            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }

    static String findRepresentativeKey(String option, boolean[] isCheck) {
        // 1. 단어의 첫 글자가 이미 단축키로 지정되었는지 살펴본다.
        String[] words = option.split(" ");
        for (int wordIdx = 0; wordIdx < words.length; wordIdx++) {

            char alphabet = words[wordIdx].charAt(0);

            if (alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char)('a' + (alphabet - 'A'));
            }
            int num = alphabet - 'a';

            if (!isCheck[num]) {
                isCheck[num] = true;
                String key = makeKey(words, wordIdx);
                return key;
            }
        }

        // 2. 왼쪽에서부터 차례대로 알파벳을 보면서 단축키로 지정 안 된 것이 있다면 단축키로 지정한다.
        for (int i = 1; i < option.length(); i++) {
            if (option.charAt(i) == ' ') {
                i += 1;
                continue;
            }

            char alphabet = option.charAt(i);

            if (alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char)('a' + (alphabet - 'A'));
            }
            int num = alphabet - 'a';

            if (!isCheck[num]) {
                isCheck[num] = true;
                String key = makeKey(option, i);
                return key;
            }
        }

        // 3. 어떠한 것도 단축키로 지정할 수 없다면 문자열 그대로 반환한다..
        return option;
    }

    // wordIdx번째의 단어의 첫글자가 단축키로 지정된 경우
    static String makeKey(String[] words, int wordIdx) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == wordIdx) {
                sb.append("[").append(word.charAt(0)).append("]");
                sb.append(word.substring(1)).append(" ");
            }
            else {
                sb.append(words[i]).append(" ");
            }
        }
        return sb.toString();
    }

    // option의 idx번째 글자가 단축키로 지정된 경우
    static String makeKey(String option, int idx) {
        StringBuilder sb = new StringBuilder();
        sb.append(option, 0, idx);
        sb.append("[").append(option.charAt(idx)).append("]");
        sb.append(option.substring(idx+1));

        return sb.toString();
    }
}
