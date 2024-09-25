package _20240827;

import java.util.*;

public class _19645_햄최몇 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        int[] burgers = new int[N];
        int sum = 0;
        
        for (int i=0;i<N;i++) {
        	burgers[i] = sc.nextInt();
            sum += burgers[i];
        }

        boolean[][] dp = new boolean[sum+1][sum+1];
        dp[0][0] = true;
        
        // dp엔 첫번째 사람과 두번째 사람이 버거를 전부 나누어 가지는 경우를 나타낸다
        for (int burger : burgers) {
            for (int i=sum;i>=0;i--) {
                for (int j=sum;j>=0;j--) {
                    if (i>=burger && dp[i-burger][j]) {
                        dp[i][j] = true;
                    }
                    if (j>=burger && dp[i][j-burger]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        int maxResult = 0;
        for (int i=0;i<=sum;i++) {
            for (int j=0;j<=sum;j++) {
                if (dp[i][j]) {
                	// k는 막내가 가질 수 있는 효용의 크기를 의미한다
                    int k = sum-i-j;
                    // 막내가 i, j보다 작은 값을 가질 때 비로소 햄버거를 먹을 수 있다(ㅠㅠ)
                    if (k<=i && k<=j) {
                        maxResult = Math.max(maxResult, k);
                    }
                }
            }
        }
        
        System.out.println(maxResult);
    }
}
