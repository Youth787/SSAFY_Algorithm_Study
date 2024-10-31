package _20241106;

import java.util.*;
import java.io.*;

public class _14502_연구소 {
	static int[][] map, copyMap;
	static int N, M, safetyZone=0;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
			}
		}
		
		dfs(0);
	
		System.out.println(safetyZone);
	}

	public static void dfs(int wallCnt) {
		if(wallCnt==3) {
			virus();
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(wallCnt+1);
					map[i][j]=0;
				}
			}
		}
	}
	public static void virus() {
		copyMap = new int[N][M];
		Queue<int[]> q = new LinkedList<>();;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j]=map[i][j];
				if(copyMap[i][j]==2) q.add(new int[] {i,j});
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0;d<4;d++) {
				int x = cur[0]+dx[d];
				int y = cur[1]+dy[d];
				
				if(x>=0 && y>=0 && x<N && y<M && copyMap[x][y]==0) {
					copyMap[x][y]=2;
					q.add(new int[] {x,y});
				}
				
			}
		}
		
		calculateSafetyZone();
	}
	
	public static void calculateSafetyZone() {
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyMap[i][j]==0) {
					cnt++;
				}
			}
		}

		safetyZone = Math.max(safetyZone, cnt);
	}

}
