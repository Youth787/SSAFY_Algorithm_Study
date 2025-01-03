package _20250106;

import java.util.*;
import java.io.*;

public class _9944_보드완주하기 {
	static int N,M,emptyCount,minMoves;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int caseNum=0;
		while((line=br.readLine()) != null) {
			caseNum++;
			StringTokenizer st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			visited = new boolean[N][M];
			emptyCount=0;
			minMoves=Integer.MAX_VALUE;

			for(int i=0;i<N;i++) {
				String tmp = br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j] = tmp.charAt(j);
					if(map[i][j]=='.') emptyCount++;
				}
			}

			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]=='.') {
						for(boolean[] row:visited) {
							Arrays.fill(row,false);
						}
						dfs(i,j,1,0,-1);
					}
				}
			}
			if(minMoves==Integer.MAX_VALUE) minMoves=-1;
			System.out.println("Case "+caseNum+": "+minMoves);


		}
	}

	private static void dfs(int x, int y, int count, int moveCnt, int dir) {
		if(count==emptyCount) {
			minMoves = Math.min(minMoves,moveCnt);
			return;
		}
		visited[x][y]=true;
		
		if(dir!=-1) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			if(nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny]=='.' && !visited[nx][ny]) {
				dfs(nx,ny,count+1,moveCnt,dir);
			} else {
				dir=-1;
			}
		}
		
		if(dir==-1) {
			for(int d=0;d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny]=='.' && !visited[nx][ny]) {
					dfs(nx,ny,count+1,moveCnt+1,d);
				}
			}
		}
		
		visited[x][y]=false;

	}




}
