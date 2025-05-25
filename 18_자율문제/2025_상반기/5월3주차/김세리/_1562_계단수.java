package _20250527;

import java.util.*;
import java.io.*;

public class _1562_계단수 {
	static final int MOD = 1_000_000_000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][][] dp = new int[N+1][10][1<<10];
		
		// 0제외하고 1자리수 초기화
		for(int i=1;i<=9;i++) {
			dp[1][i][1<<i] = 1;
		}
		
		for(int len=2;len<=N;len++) {
			for(int num=0;num<=9;num++) {
				for(int bit=0;bit<(1<<10);bit++) {
					if(num>0) {
						dp[len][num][bit | (1<<num)] += dp[len-1][num-1][bit];
						dp[len][num][bit | (1<<num)] %= MOD;
					}
					if(num<9) {
						dp[len][num][bit | (1<<num)] += dp[len-1][num+1][bit];
						dp[len][num][bit | (1<<num)] %= MOD;
					}
				}
			}
		}
		
		long ans=0;
		for(int num=0;num<=9;num++) {
			ans = (ans + dp[N][num][(1<<10)-1]) % MOD;
		}
		System.out.println(ans);
		
		
	}

}
