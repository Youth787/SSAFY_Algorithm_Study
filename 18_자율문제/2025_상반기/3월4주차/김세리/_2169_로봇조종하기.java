package _20250326;

import java.util.*;
import java.io.*;

public class _2169_로봇조종하기 {
	static int N, M;
	static int[] dx = {0,0,1};//왼,오,아래
	static int[] dy = {-1,1,0};
	static int[][] map,dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = map[0][0];
		for(int j=1;j<M;j++) {
			dp[0][j] = dp[0][j-1]+map[0][j];
		}
		
		for(int i=1;i<N;i++) {
			int[] leftMax = new int[M];
			int[] rightMax = new int[M];
			
			leftMax[0] = dp[i-1][0]+map[i][0];
			for(int j=1;j<M;j++) {
				leftMax[j] = Math.max(leftMax[j-1],dp[i-1][j])+map[i][j];
			}
			rightMax[M-1] = dp[i-1][M-1]+map[i][M-1];
			for(int j=M-2;j>=0;j--) {
				rightMax[j] = Math.max(rightMax[j+1],dp[i-1][j])+map[i][j];
			}
			
			for(int j=0;j<M;j++) {
				dp[i][j] = Math.max(leftMax[j],rightMax[j]);
			}
		}
		System.out.println(dp[N-1][M-1]);
	}

}
