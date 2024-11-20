package _20241119;

import java.util.*;
import java.io.*;

public class _2011_암호코드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int N = str.length;
		int[] pw = new int[N];
		for(int i=0;i<N;i++) {
			pw[i] = str[i]-'0';
		}
		
		if(pw[0]==0) {
			System.out.println(0);
			return;
		}
		
		int[] dp = new int[N+1];
		dp[0]=1; // 초기값 설정
		dp[1]=1; // 첫번째 수는 한 자리수만 가능
		
		for(int i=2;i<=N;i++) {
			int cur = pw[i-1];
			int pre = pw[i-2];
			int plus = pre*10+cur;
			
			if(cur != 0) {
				dp[i]=dp[i-1]%1000000;				
			}
			
			if(plus>=10 && plus<=26) {
					dp[i]=(dp[i]+dp[i-2])%1000000;					
			}
			if(cur==0 && (pre==0 || pre>2)) {
				System.out.println(0);
				return;
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}

}
