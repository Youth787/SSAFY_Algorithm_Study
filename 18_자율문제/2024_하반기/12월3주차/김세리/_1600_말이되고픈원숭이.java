package _20241223;

import java.util.*;
import java.io.*;

public class _1600_말이되고픈원숭이 {
	static int[] dxh = {-1,-2,-2,-1,1,2,2,1};
	static int[] dyh = {-2,-1,1,2,-2,-1,1,2};
	
	static int[] dxm = {-1,1,0,0};
	static int[] dym = {0,0,-1,1};
	
	static int K,W,H;
	static int[][] map;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = bfs();
		System.out.println(ans);
		
	}
	
	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[H][W][K+1];
		
		q.add(new int[] {0,0,0,0});
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			int hMoves = curr[2];
			int totalMoves = curr[3];
			
			if(x==H-1 && y==W-1) {
				return totalMoves;
			}
			
			for(int dm=0;dm<4;dm++) {
				int nx = x + dxm[dm];
				int ny = y + dym[dm];
				if(nx>=0 && ny>=0 && nx<H && ny<W && map[nx][ny]==0 && !visited[nx][ny][hMoves]) {
					visited[nx][ny][hMoves] = true;
					q.add(new int[] {nx,ny,hMoves,totalMoves+1});
				}
			}
			
			
			if(hMoves<K) {
				for(int dh=0;dh<8;dh++) {
					int nx = x + dxh[dh];
					int ny = y + dyh[dh];
					if(nx>=0 && ny>=0 && nx<H && ny<W && map[nx][ny]==0 && !visited[nx][ny][hMoves+1]) {
						visited[nx][ny][hMoves+1] = true;
						q.add(new int[] {nx,ny,hMoves+1,totalMoves+1});
					}
				}
				
			}
			
		}
		
		return -1;
	}

}
