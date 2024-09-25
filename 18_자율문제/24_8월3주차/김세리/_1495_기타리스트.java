package _20240820;

import java.util.*;
import java.io.*;

public class _1495_기타리스트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] V = new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] dp = new boolean[N+1][M+1];
		dp[0][S]=true;
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=M;j++) {
				// 지금 전 곡의 볼륨
				if(dp[i-1][j]) {
					// 볼륨 높였을 때 재생가능한 경우
					if(j+V[i-1]<=M) {
						dp[i][j+V[i-1]]=true;
					}
					// 볼륨 낮췄을 때 재생 가능한 경우
					if(j-V[i-1]>=0) {
						dp[i][j-V[i-1]]=true;
					}
				}
			}
		}
		// 재생 가능하면 그 최대 볼륨으로 갱신, 불가할 경우 -1 출력
		int maxVolume =-1;
		for(int j=0;j<=M;j++) {
			if(dp[N][j]) {
				maxVolume=j;
			}
		}
		
		System.out.println(maxVolume);
	}

}
