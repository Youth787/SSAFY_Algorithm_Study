package _20250106;

import java.util.*;
import java.io.*;

public class _10026_적록색약 {
	static char[][] map;
	static boolean[][] visitedn,visited;
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		visitedn = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		int ansn=0;
		int ans=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visitedn[i][j]) {
					dfsn(i,j);
					ansn++;
				}
				if(!visited[i][j]) {
					dfs(i,j);
					ans++;
				}
			}
		}
		
		System.out.println(ansn+" "+ans);
		
	}
	
	static void dfsn(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		char color = map[x][y];
		visitedn[x][y]=true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for(int d=0;d<4;d++) {
				int nx = curr[0]+dx[d];
				int ny = curr[1]+dy[d];
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visitedn[nx][ny] && map[nx][ny]==color) {
					visitedn[nx][ny]=true;
					q.add(new int[] {nx,ny});
				}
			}
			
		}
	}
	static void dfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		boolean color = false;
		if(map[x][y]=='B') {
			color=true;
		}
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for(int d=0;d<4;d++) {
				int nx = curr[0]+dx[d];
				int ny = curr[1]+dy[d];
				boolean chk = false;
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]) {
					if(map[nx][ny]=='B') chk=true;
					if(chk==color) {
						visited[nx][ny]=true;
						q.add(new int[] {nx,ny});						
					}
				}
			}
			
		}
	}

}
