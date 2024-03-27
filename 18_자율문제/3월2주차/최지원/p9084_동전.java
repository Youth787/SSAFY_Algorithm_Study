//package p9084_동전;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();//동전 가지 수
			int [] coin = new int [n+1];//동전 금액(오름차순)
			for (int i = 1; i <= n ; i++) coin[i] = sc.nextInt();
			int m = sc.nextInt();//목표 금액
			//주어진 금액을 만드는 모든 방법을 세는 문제
			int [] dp = new int [m+1];//1~목표 금액까지 고려
			for (int i = 1; i <= n; i++) {
                for (int j = 1; j <=m; j++) {
                    if (j - coin[i] > 0) {
                        dp[j] = dp[j] + dp[j-coin[i]];
                    } else if (j - coin[i] == 0) {
                        dp[j]++;
                    }
                }
            }
			
			sb.append(dp[m]).append('\n');
		}
		
		System.out.println(sb);
	} //main
} //class
