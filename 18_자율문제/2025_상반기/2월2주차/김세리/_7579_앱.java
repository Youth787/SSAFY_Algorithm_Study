package _20250217;

import java.util.*;
import java.io.*;

public class _7579_앱 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] memory = new int[N];
		int[] cost = new int[N];
		int maxMemory = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int sumCost = 0;
		for(int i=0;i<N;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sumCost +=cost[i];
		}
		int[] dp = new int[sumCost+1];
		Arrays.fill(dp,0);
		// dp[j]는 j 비용으로 확보 가능한 메모리의 최댓값
		for(int i=0;i<N;i++) {
			for(int j=sumCost;j>=cost[i];j--) {
				dp[j] = Math.max(dp[j],dp[j-cost[i]]+memory[i]);
			}
		}
		int ans=Integer.MAX_VALUE;
		for(int c=0;c<=sumCost;c++) {
			if(dp[c]>=M) {
				ans = Math.min(ans,c);
			}
		}
		
		System.out.println(ans);
	}

}
