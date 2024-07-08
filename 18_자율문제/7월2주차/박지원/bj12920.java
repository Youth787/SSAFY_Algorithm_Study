//백준 평범한배낭2 자바
//2차원 dp를 풀어보고싶어서 가져온 문제인데..... 생각보다 더 어려웠따..
//https://chb2005.tistory.com/130
//기본적인 배낭 문제는 물건의 무게와 만족도를 고려해 최대 만족도를 찾는 것이지만, 이 문제는 물건이 여러 개 있을 수 있어 Binary Splitting 방법을 사용한다.

      // ** Binary Splitting은 특정 개수의 물건을 여러 개의 묶음으로 나누어 처리하는 방법으로, DP를 사용해 효율적으로

      //     문제를 해결 할 수 있다.

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static class Stuff {
        int weight, value;
        public Stuff(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    private static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Stuff> stuff = new ArrayList<>();
        //index를 1부터 하기 위해 null값 한개 추가
        stuff.add(new Stuff(0, 0));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 무게
            int c = Integer.parseInt(st.nextToken()); // 가치
            int k = Integer.parseInt(st.nextToken()); // 갯수

            int tempK = 1;
            while (tempK <= k) {
                stuff.add(new Stuff(tempK * v, tempK * c));
                k -= tempK;
                tempK *= 2;
            }
            if (k != 0) {
                stuff.add(new Stuff(k * v, k * c));
            }
        }

        int[][] dp = new int[stuff.size() + 1][m + 1];
        for (int i = 1; i < stuff.size(); i++) {
            for (int j = 1; j <= m; j++) {
                if (j < stuff.get(i).weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stuff.get(i).weight] + stuff.get(i).value);
                }
            }
        }

        System.out.println(dp[stuff.size() - 1][m]);
    }

}
