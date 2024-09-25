//백준 예산 자바 파라메트릭 서치
//이분탐색과 구현방법은 비슷하지만, 이분탐색이 정렬이 필요하다면, 파라메트릭은 정렬 필요없이 범위만 알면 됨!
//https://sarah950716.tistory.com/16 파라메트릭 서치 관련 블로그
//https://velog.io/@lake/%EC%9D%B4%EB%B6%84%ED%83%90%EC%83%89-%ED%8C%8C%EB%9D%BC%EB%A9%94%ED%8A%B8%EB%A6%AD-%EC%84%9C%EC%B9%98Parametric-Search 파라메트릭 서치 관련 블로그

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] budget;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        budget = new int[n];
        int left = 0, right = -1;
        for (int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, budget[i]);
        }
        m = Integer.parseInt(br.readLine());
        while (left <= right) {
            int mid = (left + right) / 2;
            long b = 0;
            for (int i = 0; i < n; i++) {
                if (budget[i] > mid) b += mid;
                else b += budget[i];
            }
            if (b <= m) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(right);
    }

}
