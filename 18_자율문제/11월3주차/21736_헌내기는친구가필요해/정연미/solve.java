package _11월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해 {
	static int[][] dir = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] visit;
	static String[][] arr;
	static int cnt, N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new String[N][M];
 		visit = new boolean[N][M];
 		
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split("");
			for(int j=0; j<M;j++) {
				arr[i][j] = input[j]; 
			}
		}// for end 입력받기 완료 
		
		for(int i=0; i<N ;i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j].equals("I")) {
					int x = i;
					int y = j;
					DFS(x,y);
				}
			}
		}
		System.out.println(cnt==0?"TT":cnt);
	}// main end
	
	public static void DFS(int x, int y) {
		visit[x][y] = true;
		
		if(arr[x][y].equals("X")) 
			return;
		if(arr[x][y].equals("P")) 
			cnt++;
		
		for(int k=0; k<4; k++) {
			int ix = x+dir[k][0];
			int jy = y+dir[k][1];
			if(ix>=0 && ix <N && jy>=0 && jy <M && !visit[ix][jy]) 
				DFS(ix,jy);
		}
	}// method end 
}





