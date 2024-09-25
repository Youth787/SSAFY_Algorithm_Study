package _20240911;

import java.util.*;
import java.io.*;

public class _1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int[] dp = new int[X+1];

		for(int i=X;i>0;i--) {
			if(i%3==0) {
				if(dp[i/3]==0 && i/3>0) {
					dp[i/3]=dp[i]+1;
				} else if(dp[i/3]!=0 && i/3>0) {
					dp[i/3]= Math.min(dp[i/3], dp[i]+1);
				}
			}
			if (i%2==0) {
				if(dp[i/2]==0 && i/2>0) {
					dp[i/2]=dp[i]+1;
				} else if(dp[i/2]!=0 && i/2>0) {
					dp[i/2]= Math.min(dp[i/2], dp[i]+1);
				}
			}

			if(dp[i-1]==0 && i-1>0) {
				dp[i-1]=dp[i]+1;
			} else if(dp[i-1]!=0 && i-1>0) {
				dp[i-1]= Math.min(dp[i-1], dp[i]+1);
			}

		}
		System.out.print(dp[1]);
	}

}
