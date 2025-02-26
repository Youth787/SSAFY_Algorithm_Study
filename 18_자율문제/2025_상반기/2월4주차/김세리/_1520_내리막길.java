package _20250303;

import java.util.*;
import java.io.*;

public class _1520_내리막길 {
	static int M,N;
	static int[][] map, dp;
	static int[]dx = {-1,1,0,0};
	static int[]dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		// dp 배열은 특정 위치에서 도착지점까지 도착 가능한 경우의 수를 저장하는 배열임
		dp = new int[M][N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0));
		System.out.println(Arrays.deepToString(map));
		System.out.println(Arrays.deepToString(dp));
//		System.out.println(dp[M-1][N-1]);
	}
	static int dfs(int x, int y) {
		if(x==M-1 && y==N-1) {
			return 1;
		}
		// 해당 지점의 값이 -1이 아니라면 이미 계산된 지점이므로
		// 계산된 값을 반환하는 것
		if(dp[x][y]!=-1) return dp[x][y];
		// 계산하기 전에 0으로 바꿔준다(방문체크 하는 이유와 비슷)
		dp[x][y]=0;
		
		for(int d=0;d<4;d++) {
			int dr = x+dx[d];
			int dc = y+dy[d];
			// 그리고 해당 지점의 dp 값은
			// 이동 가능한 지점이 있을 경우 그 지점에서 도착지까지의 경우의 수를 더해주는 것과 같다
			if(dr>=0 && dr<M && dc>=0 && dc<N && map[x][y]>map[dr][dc]) {
				dp[x][y] += dfs(dr,dc);
			}
		}
		return dp[x][y];
		
	}

}
