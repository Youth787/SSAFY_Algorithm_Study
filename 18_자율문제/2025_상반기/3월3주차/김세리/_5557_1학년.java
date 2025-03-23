package _20250324;

import java.util.*;
import java.io.*;

public class _5557_1학년 {
	static int N,lastNum;
	static int[] nums;
	static long[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N-1];
		for(int i=0;i<N-1;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		lastNum = Integer.parseInt(st.nextToken());
		dp = new long[N-1][21];
		dp[0][nums[0]]=1;
		for(int i=1;i<N-1;i++) {
			for(int j=0;j<=20;j++) {
				if(dp[i-1][j]>0) {
					int plus = j+nums[i];
					int minus = j-nums[i];
					if(plus<=20) dp[i][plus] +=dp[i-1][j];
					if(minus>=0) dp[i][minus] +=dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N-2][lastNum]);
	}

}
