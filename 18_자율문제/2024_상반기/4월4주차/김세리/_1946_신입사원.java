package _202404224;

import java.io.*;
import java.util.*;

public class _1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                score[i][0] = Integer.parseInt(input[0]);
                score[i][1] = Integer.parseInt(input[1]);
            }
            // 서류 점수에 따라 정렬
            Arrays.sort(score, (a, b) -> Integer.compare(a[0], b[0]));

            int ans = 1; // 최소 한 명은 뽑힘
            // 비교할 인터뷰 스코어 설정
            int minScore = score[0][1];
            for (int i = 1; i < N; i++) {
                if (score[i][1] < minScore) {
                    ans++;
                    minScore = score[i][1]; // 점수 갱신
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
