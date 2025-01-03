package _20250106;

import java.util.*;
import java.io.*;

public class _1937_욕심쟁이판다 {
	static int n,ans;
	static int[][] map, dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		ans=0;
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ans = Math.max(ans, dfs(i,j));
			}
		}
		System.out.println(ans);
	}
	private static int dfs (int x, int y) {
		if(dp[x][y]!=0) {
			return dp[x][y];
		}
		dp[x][y]=1;
		
		for(int d=0;d<4;d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]>map[x][y]) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx,ny)+1);
			}
		}
		return dp[x][y];
	}

}
