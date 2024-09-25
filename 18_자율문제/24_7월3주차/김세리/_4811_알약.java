package _20240716;

import java.util.*;
import java.io.*;

public class _4811_알약 {
	
	static long[][] dp = new long[31][31];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<=30;i++) {
			for(int j=0;j<=30;j++) {
				dp[i][j]=-1;
			}
		}
		
		while(true) {
			int N = sc.nextInt();
			if(N==0) break;
			
			System.out.println(solve(N,0));
		}
		
		sc.close();
		
	}//main

	static long solve(int w, int h) {
		
		// 모든 알약을 사용한 경우엔 1을 반환
		if(w==0 && h==0) return 1;
		
		// -1이 아니라면 이미 계산된 것이므로 해당 값 반환
		if(dp[w][h] != -1) return dp[w][h];
		
		long result=0;
		// w를 하나 줄이는 경우: w가 줄고, h가 하나 늘어남
		if(w>0) result += solve(w-1,h+1);
		// h를 줄이는 경우: w는 변화 없고, h만 하나 줌
		if(h>0) result += solve(w,h-1);
		
		return dp[w][h] = result;
	}
}
