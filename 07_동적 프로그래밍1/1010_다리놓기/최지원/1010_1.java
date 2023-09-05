package p1010_다리놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[문제] 강 서쪽의 사이트 n개와 동쪽의 사이트 m개(n<=m)를 서로 겹치지 않고 연결할 수 있는 최대 경우의 수
//[입력] t, n m(0<n<=m<30)
public class Main {
	
	public static int[][] dp = new int [30][30];
	
	public static int comb(int n, int m) {
		//기저
		if (dp[n][m]>0) return dp[n][m];
		//재귀1
		if  (n==m || m==0) return dp[n][m]=1;
		//재귀2
		return dp[n][m] = comb(n-1, m-1) + comb(n-1,m);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc=0; tc<t; tc++) {
			String [] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			//조합
			sb.append(comb(m,n)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	

}
