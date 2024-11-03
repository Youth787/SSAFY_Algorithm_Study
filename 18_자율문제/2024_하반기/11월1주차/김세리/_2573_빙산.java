package _20241106;

import java.util.*;
import java.io.*;

public class _2573_빙산 {
	static int N, M, year=0;
	static int[][] map,copyMap;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			int icebergCnt = countIcebergs();
			
			if(icebergCnt >=2) {
				System.out.println(year);
				break;
			}
			if(icebergCnt==0) {
				System.out.println(0);
				break;
			}
			melt();
			year++;
		}
	}//main
	public static int countIcebergs() {
		boolean[][] visited = new boolean[N][M];
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>0 && !visited[i][j]) {
					dfs(i,j,visited);
					cnt++;
				}
			}
		}
		return cnt;
		
	}
	public static void dfs(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		for(int d=0;d<4;d++) {
			int dr = x + dx[d];
			int dc = y + dy[d];
			
			if(dr>=0 && dr<N && dc>=0 && dc<M && map[dr][dc]>0 && !visited[dr][dc]) {
				dfs(dr,dc,visited);
			}
		}
	}
	public static void melt() {
		
		copyMap = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j]=map[i][j];
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j]>0) {
					int cnt=0;
					for(int d=0;d<4;d++) {
						int x = i + dx[d];
						int y = j + dy[d];
						if(x>=0 && x<N && y>=0 && y<M && copyMap[x][y]==0) {
							cnt++;
						}
					}
					map[i][j]=Math.max(0,map[i][j]-cnt);
				}
			}
		}
	}
	

}
