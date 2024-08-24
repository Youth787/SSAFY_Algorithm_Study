package _20240827;

import java.util.*;

public class _2294_동전2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coins = new int[n];
		for(int i=0;i<n;i++) {
			coins[i] = sc.nextInt();
		}
		// 금액의 크기만큼 dp만든다
		int[] dp = new int[k+1];
		Arrays.fill(dp, 10001);
		dp[0]=0;
		
		for(int i=0;i<n;i++) {
			for(int j=coins[i];j<=k;j++) {
				// 현재 동전 사용하지 않았을 때, 사용할 때 중 더 적은 동전을 사용하는 값을 입력
				dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
			}
		}
		
		System.out.println(dp[k]==10001 ? -1 : dp[k]);
	}

}
