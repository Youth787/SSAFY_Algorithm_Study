package _20241113;

import java.util.*;
import java.io.*;

public class _17070_파이프옮기기1_복습2 {
	private static int N, cnt=0;
	private static int[][] map;
	private static int[][][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int [N][N];
		dp = new int [N][N][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0:가로, 1: 세로, 2: 대각선
		dp[0][1][0]=1;
		for(int i=0;i<N;i++) {
			for(int j=2;j<N;j++) {
				if(map[i][j]==0) {
					if(j-1>=0) {
						dp[i][j][0] = dp[i][j-1][0]+dp[i][j-1][2];						
					}
					if(i-1>=0) {
						dp[i][j][1] = dp[i-1][j][1]+dp[i-1][j][2];
					}
					if(i-1>=0 && j-1>=0 && map[i-1][j]==0 && map[i][j-1]==0) {
						dp[i][j][2] = dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
					}
				}
			}
		}
		cnt = dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2];
		
		System.out.println(cnt);
	}

}
