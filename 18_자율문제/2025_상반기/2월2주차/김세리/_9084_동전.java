package _20250217;

import java.util.*;
import java.io.*;

public class _9084_동전 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] coins = new int[N];
			for(int i=0;i<N;i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			
			int goal = Integer.parseInt(br.readLine());
			int[] dp = new int[goal+1];
			
			dp[0]=1;
			for(int coin : coins) {
				for(int i=coin;i<=goal;i++) {
					dp[i] += dp[i-coin];
				}
			}
			System.out.println(dp[goal]);
			
		}
	}

}
