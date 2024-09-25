package p1018_체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * m*n크기 보드에서 흰,검 색칠되어 있고
 * 8*8 체스판으로 만드려고 함
 * 아무데서나 8*8 크기를 잘라낼때 다시 칠해야 하는 정사각형의 최소 개수
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean [][] board = new boolean[n][m]; //W = T , B = F
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				if (tmp.charAt(j) == 'W') {
					board[i][j] = true;
				} else {
					board[i][j] = false;
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= n-8; i++) { //<= n-8
			for (int j = 0; j <= m-8; j++) {
				int cnt = 0;
				boolean firstColor = board[i][j];
				for (int p = i; p < i+8; p++) {
					for (int q = j; q < j+8; q++) {
						if (board[p][q] != firstColor) {
							cnt++;
						}
						firstColor = !firstColor;
					}
					firstColor = !firstColor;
				}
				cnt = Math.min(cnt, 64-cnt);
				min = Math.min(min, cnt);
			}
		}
		
		System.out.println(min);
		
	} //main

} //class
