package _20240911;

import java.util.*;
import java.io.*;

public class _14940_쉬운최단거리 {
	static int n, m, destinationR, destinationC;
	static int[][] map, answer;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		answer = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] =tmp;
				// 도달할 수 없다고 일단 초기화함
				if(tmp==1) answer[i][j] = -1;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==2) {
					bfs(i,j);
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(answer[i][j]+" ");	
			}
			System.out.println();
		}
		
	}//main
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		q.add(new int[] {x,y});
		visited[x][y] = true;
		answer[x][y]=0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currX = curr[0];
			int currY = curr[1];
			
			for(int i=0;i<4;i++) {
				int nr = currX + dx[i];
				int nc = currY + dy[i];
				
				if(nr<0 || nc<0 || nr>=n || nc>=m || map[nr][nc]==0 || visited[nr][nc]) continue;
				
				q.add(new int[] {nr,nc});
				visited[nr][nc] = true;
				answer[nr][nc] = answer[currX][currY]+1;
			}
		}
	}//bfs

}
