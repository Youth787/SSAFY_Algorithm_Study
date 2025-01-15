//백준 수 나누기 게임 자바
//에라토스테네스의 체

import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[] card, index, score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        card = new int[n + 1];
        index = new int[1000001];
        score = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            index[card[i]] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int idx = card[i] * 2; idx <= 1000000; idx += card[i]) {
                if (index[idx] >= 1) {
                    score[index[idx]]--;
                    score[i]++;
                }
            }
        }
        for (int i = 1; i <= n; i++) sb.append(score[i]).append(" ");
        System.out.println(sb.toString());



    }


}
