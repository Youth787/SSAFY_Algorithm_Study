//소프티어 성적 평균 자바
// 누적합, 세그먼트트리 연습하는 문제
// 세그먼트 트리로 공부해서 다시 풀어보기

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] scores = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            double avg = 0;
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            long sum = 0;
            for (int score = first; score <= second; score++) {
                sum += scores[score];
            }
            double cnt = second - first + 1;
            avg = (Math.round(sum / cnt * 100))/100.0;
            System.out.printf("%.2f\n", avg);
        }

        
    }
}
