package _20250203;

import java.util.*;
import java.io.*;

public class _1947_선물전달 {
	static final int MOD = 1_000_000_000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N==1) {
			System.out.println(0);
			return;
		}
		if(N==2) {
			System.out.println(1);
			return;
		}
		
		long prev2=0; // dp[1]
		long prev1=1; // dp[2]
		long result=0;
		
		for(int i=3;i<=N;i++) {
			// 점화식 활용
			result = (i-1) * (prev1+prev2) % MOD;
			prev2 = prev1;
			prev1 = result;
		}
		System.out.println(result);
	}

}
