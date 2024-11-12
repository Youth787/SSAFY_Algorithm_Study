package _20241113;

import java.util.*;
import java.io.*;

public class _17070_파이프옮기기1_복습 {
	private static int N, cnt=0;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int [N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0:가로, 1: 세로, 2: 대각선
		movePipe(0,1,0);
		
		System.out.println(cnt);
	}
	private static void movePipe(int x, int y, int type) {
		if(x==N-1 && y==N-1) cnt++;
		
		if(type==0) {
			if(y+1<N && map[x][y+1]==0) {
				movePipe(x,y+1,0);
			}
			if(x+1<N && y+1<N && map[x+1][y]==0 && map[x][y+1]==0 && map[x+1][y+1]==0) {
				movePipe(x+1,y+1,2);
			}
		}
		
		if(type==1) {
			if(x+1<N && map[x+1][y]==0) {
				movePipe(x+1,y,1);
			}
			if(x+1<N && y+1<N && map[x+1][y]==0 && map[x][y+1]==0 && map[x+1][y+1]==0) {
				movePipe(x+1,y+1,2);
			}
		}
		
		if(type==2) {
			if(y+1<N && map[x][y+1]==0) {
				movePipe(x,y+1,0);
			}
			if(x+1<N && map[x+1][y]==0) {
				movePipe(x+1,y,1);
			}
			if(x+1<N && y+1<N && map[x+1][y]==0 && map[x][y+1]==0 && map[x+1][y+1]==0) {
				movePipe(x+1,y+1,2);
			}
		}
	}

}
