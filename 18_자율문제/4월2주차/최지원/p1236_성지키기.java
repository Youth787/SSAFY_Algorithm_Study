package p1236_성지키기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 직사각형 모양의 성 1층에 모든 행, 모든 열에 1명의 경비원이 있어야 할때 
 * 몇명의 경비원을 최소로 추가해야 하는지
 * n m, 성의 상태 .빈칸,X는 경비원있는 칸
 * 
 * */
public class Main {
	static int n; //세로 크기
	static int m; //가로 크기
	static boolean [] row; //세로줄 경비원 유무
	static boolean [] col; //가로줄 경비원 유무
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		row = new boolean[n];
		col = new boolean[m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == 'X') {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		int lastR = 0;
		int lastC = 0;
		for (int i = 0; i < n; i++) {
			if (!row[i]) {
				lastR++;
			}
		}
		for (int j = 0; j < m; j++) {
			if (!col[j]) {
				lastC++;
			}
		}		
		
		System.out.println(Math.max(lastR, lastC));
		
	} //main

} //class
