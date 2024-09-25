package _11월2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input1 = br.readLine().split("");
		String[] input2 = br.readLine().split("");
		
		int[][] dp = new int[input1.length+1][input2.length+1];
 		
		for(int i =1; i<=input2.length; i++) {
			for(int j=1; j<=input1.length; j++) {
				if(input2[i-1].equals(input1[j-1])) {
					dp[j][i] = dp[j-1][i-1] +1;
				}else {
					dp[j][i] = Math.max(dp[j][i-1],dp[j-1][i]);
				}
			}
		}// for end
		
		System.out.println(dp[input1.length][input2.length]);
	}// main end 
}
