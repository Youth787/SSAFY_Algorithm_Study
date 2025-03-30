package _20250326;

import java.util.*;
import java.io.*;

public class _15961_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d+1]; // 초밥별 먹은 개수
        int unique = 0; // 서로 다른 초밥 종류 수

        // 초기 윈도우 세팅
        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) unique++;
            count[sushi[i]]++;
        }

        int max = unique;
        if (count[c] == 0) max++; // 쿠폰 사용 고려

        // 슬라이딩 윈도우 진행
        for (int i = 1; i < N; i++) {
            int remove = sushi[i - 1];
            int add = sushi[(i + k - 1) % N]; // 원형이므로 %N

            // remove 초밥
            count[remove]--;
            if (count[remove] == 0) unique--;

            // add 초밥
            if (count[add] == 0) unique++;
            count[add]++;

            int temp = unique;
            if (count[c] == 0) temp++; // 쿠폰 초밥을 먹은 적 없다면 +1

            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}
