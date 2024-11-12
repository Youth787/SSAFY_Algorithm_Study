package _20241113;

import java.util.*;
import java.io.*;

public class _16724_피리부는사나이 {
	private static int N, M;
	private static char[][] map;
	private static int[][] state;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j] = tmp[j];
			}
		}
		state = new int[N][M];
		int cnt =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(state[i][j]==0) {
					if(foundGroup(i,j)) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
	private static boolean foundGroup(int x,int y) {
		
		// true: 새그룹, false: 이미 있는 그룹
		// 0: 아직 방문 안함, 1: 방문진행중, 2: 그룹 카운팅 된 곳
		
		if(state[x][y]==1) return true;
		if(state[x][y]==2) return false;
		
		state[x][y] = 1;
		int nx=x,ny=y;
		if(map[x][y]=='U') nx--;
		if(map[x][y]=='D') nx++;
		if(map[x][y]=='L') ny--;
		if(map[x][y]=='R') ny++;
		
		// 새 그룹일 경우 방문중인던 곳도 2로 바꿔주고 카운팅 위해 true반환
		if(foundGroup(nx,ny)) {
			state[x][y]=2;
			return true;
		}
		// 기존에 있던 그룹일 경우 방문중이던 곳도 2로 바꿔주지만 카운팅은 하지 않기 위해 false 반환
		state[x][y] = 2;
		return false;
		
	}

}
