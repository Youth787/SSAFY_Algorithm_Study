package Algo_스터디.August_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        out:
        for (int tc = 1; tc <= T; tc++) {
            String word = br.readLine();

            // 회문일 경우
            StringBuilder sb = new StringBuilder(word);
            if (word.equals(sb.reverse().toString())) {
                result.append(0).append("\n");
                continue out;
            }

            // 회문이 아닐경우
            int leftpoint = 0;
            int rightpoint = word.length() - 1;
            while (leftpoint < rightpoint) {
                if (word.charAt(leftpoint) != word.charAt(rightpoint)) {
                    if(check(word, leftpoint+1, rightpoint)||check(word,leftpoint,rightpoint-1)){
                        result.append(1).append("\n");
                        continue out;
                    }else{
                        result.append(2).append("\n");
                        continue out;
                    }
                }
                leftpoint++;
                rightpoint--;
            }
        }
        System.out.println(result.toString());
    }
    public static boolean check(String word, int leftpoint, int rightpoint){
        while(leftpoint<rightpoint){
            if (word.charAt(leftpoint) != word.charAt(rightpoint)) return false;
            leftpoint++;
            rightpoint--;
        }
        return true;
    }
}
