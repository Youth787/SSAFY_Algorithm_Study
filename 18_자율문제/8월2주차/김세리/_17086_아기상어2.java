package _20240813;

import java.util.*;
import java.io.*;

public class _17086_아기상어2 {
	static int[][] map;
	static int[] dr = {-1,0,1,-1,1,-1,0,1};
	static int[] dc = {-1,-1,-1,0,0,1,1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map= new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		int maxDistance =0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					int distance = bfs(i,j,N,M);
					maxDistance = Math.max(maxDistance, distance);
				}
			}
		}
		
		System.out.println(maxDistance);
		
	}//main
	static int bfs(int startRow,int startCol, int N, int M) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(new int[] {startRow, startCol});
		visited[startRow][startCol]=true;
		int distance=0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			distance++;
			
			for(int i=0;i<size;i++) {
				int[] current = q.poll();
				int r = current[0];
				int c = current[1];
				
				for(int d=0;d<8;d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
						if(map[nr][nc]==1) {
							return distance;
						}
						q.add(new int[] {nr,nc});
						visited[nr][nc]=true;
					}
				}
			}
		}
		return Integer.MAX_VALUE; //이론상 도달X
		
	}//bfs
}
