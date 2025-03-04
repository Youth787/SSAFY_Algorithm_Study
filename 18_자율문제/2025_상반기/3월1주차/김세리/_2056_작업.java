package _20250310;

import java.util.*;
import java.io.*;

public class _2056_작업 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] dp = new int[N+1];
		int ans=0;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int preJobCnt = Integer.parseInt(st.nextToken());
			if(preJobCnt==0) {
				dp[i] = time;
				ans = Math.max(ans,dp[i]);
			}else {
				int preJobMax=0;
				for(int j=0;j<preJobCnt;j++) {
					int preJobIdx = Integer.parseInt(st.nextToken());
					preJobMax = Math.max(preJobMax,dp[preJobIdx]);
				}
				dp[i] = preJobMax+time;
				ans = Math.max(ans,dp[i]);
			}
		}
		System.out.println(ans);
	}
}
