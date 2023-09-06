package p1010_다리놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[문제] 강 서쪽의 사이트 n개와 동쪽의 사이트 m개(n<=m)를 서로 겹치지 않고 연결할 수 있는 최대 경우의 수
//[입력] t, n m(0<n<=m<30)

//조합 : 동쪽의 사이트 m개에서 서쪽 사이트 n개와 연결될 것을 고르면 됨. 순서는 자동으로 서쪽 사이트 순대로 정해짐.
public class Main {
	
	public static int[][] dp = new int [30][30]; //DP : 동적 계획법 : 실행 중 실행에 필요한 메모리를 할당함
	//상향식 : 하위에서 문제를 핵셜해나가면서 먼저 계산한 문제들의 값을 활용해서 상위문제 해결하는 방식 
	//(EX. 피보나치에서 DP[n+1]로 만들어놓고 [1]=1, [2]=1, for문으로 dp[x+1(n)]까지의 값을 계산해서 마지막에 리턴하는 느낌)
	//하향식 : 상위문제를 해결하기 위해 하위문제를 재귀적으로 호출하면서 상위문제 해결까지(EX. 피보나치 에서 0 과 1의 경우를 재귀로 넣어놓은 것 같은 느낌)
	//메모제이션 = 캐싱: 한번 계산한 결과를 메모리 공간에 메모(같은 문제를 다시 호출하면 메모했던 결과 그대로 가져옴
	
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
