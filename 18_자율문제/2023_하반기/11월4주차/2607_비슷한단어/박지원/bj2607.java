import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        String target = br.readLine();
        for (int i = 0; i < n - 1; i++) {
            int[] count = new int[26];
            for (int j = 0; j < target.length(); j++) {
                count[target.charAt(j) - 'A']++;
            }

            String str = br.readLine();
            int same = 0; // 같은 단어 갯수
            for (int j = 0; j < str.length(); j++) {
                if (count[str.charAt(j) - 'A'] > 0) {
                    same++;
                    count[str.charAt(j) - 'A']--;
                }
            }
            //target 길이와 비교 문자열 길이 차이
            //같은 경우or 한 글자만 바뀔 경우
            if (target.length() == str.length() && (target.length() == same || target.length() - 1 == same)) {
                answer++;
            } else if (target.length() == str.length() - 1 && str.length() - 1 == same) {
                answer++;
            } else if (target.length() == str.length() + 1 && str.length() == same) {
                answer++;
            }


        }

        System.out.println(answer);
    }

}


//https://jyunslog.tistory.com/22
