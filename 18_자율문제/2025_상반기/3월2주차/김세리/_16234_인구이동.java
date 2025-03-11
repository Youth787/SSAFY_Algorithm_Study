package _20250317;

import java.util.*;
import java.io.*;

public class _16234_인구이동 {
	static int N,L,R;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static boolean chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans=0;
		while(true) {
			chk=false;
			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) {
						chkCities(i,j);
					}
				}
			}
			
			if(!chk) break;
			ans++;
		}
		System.out.println(ans);
	}
	static void chkCities(int x,int y) {
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> citiesOpened = new LinkedList<>();
		
		q.add(new int[] {x,y});
		citiesOpened.add(new int[] {x,y});
		visited[x][y]=true;
		
		int citiesOpenedCnt=1;
		int population=map[x][y];
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			for(int d=0;d<4;d++) {
				int dr = curr[0]+dx[d];
				int dc = curr[1]+dy[d];
				if(dr>=0 && dc>=0 && dr<N && dc<N && Math.abs(map[curr[0]][curr[1]]-map[dr][dc])>=L
						&& Math.abs(map[curr[0]][curr[1]]-map[dr][dc])<=R && !visited[dr][dc]) {
					citiesOpenedCnt++;
					population += map[dr][dc];
					visited[dr][dc]=true;
					chk=true;
					
					citiesOpened.add(new int[] {dr,dc});
					q.add(new int[] {dr,dc});
					
				}
			}
			
		}
		int newpopulation = population/citiesOpenedCnt;
		
		while(!citiesOpened.isEmpty()) {
			int[] curr = citiesOpened.poll();
			map[curr[0]][curr[1]]=newpopulation;
		}
//		System.out.println(Arrays.deepToString(map));
	}

}
