package _20250324;

import java.util.*;
import java.io.*;

public class _14728_벼락치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[] K = new int[N+1];
		int[] S = new int[N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			K[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][T+1];

		for(int i=1;i<=N;i++) {
			for(int j=0;j<=T;j++) {
				if(K[i]<=j) dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-K[i]]+S[i]);
				else dp[i][j] = dp[i-1][j];
			}
		}
		System.out.println(dp[N][T]);
	}

}
