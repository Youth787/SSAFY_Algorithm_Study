package _20250527;

import java.util.*;

public class _1106_호텔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int N = sc.nextInt();
		
		int[] cost = new int[N];
		int[] customer = new int[N];
		for(int i=0;i<N;i++) {
			cost[i] = sc.nextInt();
			customer[i] = sc.nextInt();
		}
		
		int maxCost = 100*1000 +1;
		int[] dp = new int [C+101];
		Arrays.fill(dp, maxCost);
		dp[0]=0;
		for(int i=0;i<N;i++) {
			for(int j=customer[i];j<=C+100;j++) {
				dp[j] = Math.min(dp[j], dp[j-customer[i]]+cost[i]);
			}
		}
		
		int ans = maxCost;
		for(int i=C;i<=C+100;i++) {
			ans = Math.min(ans, dp[i]);
		}
		
		System.out.print(ans);
	}

}
