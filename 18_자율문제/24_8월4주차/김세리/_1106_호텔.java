package _20240827;

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
		// 적어도 C명 이상을 늘리는 것이므로 C보다 더 커도 무방함
		// 따라서 최대로 더 얻을 수 있는 고객의 수인 100을 추가한 크기의 배열을 만들어야 한다
		int maxCost = 100*1000 +1;
		int[] dp = new int [C+101];
		Arrays.fill(dp, maxCost);
		dp[0]=0;
		for(int i=0;i<N;i++) {
			for(int j=customer[i];j<=C+100;j++) {
				dp[j] = Math.min(dp[j], dp[j-customer[i]]+cost[i]);
			}
		}
		
		// 답이 가능한 것들 중에서 가장 작은 값이 ans임
		int ans = maxCost;
		for(int i=C;i<=C+100;i++) {
			ans = Math.min(ans, dp[i]);
		}
		
		System.out.print(ans);
	}

}
