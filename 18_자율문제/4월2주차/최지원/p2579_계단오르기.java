package p2579_계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * 
 * 
 * */
public class Main {
	static int[] stairs;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stairs = new int[n+1];
		dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		} //입력
		
		dp[1] = stairs[1];
		if (n >= 2) {
			dp[2] = stairs[1] + stairs[2]; //1, 2번째 다 밟는다고 일단 가정
		}
		
		
		System.out.println(findMax(n));
		
		/*
		 * 	for (int i = 3; i <= n; i++) {
		 *		dp[i] = Math.max(dp[i-2], dp[i-3]+stairs[i-1]) + stairs[i];
		 *	}
		 * 재귀 안하고 이렇게 해도 됨
		 * 결극 같은건 해당 칸 고려할 때 [2개 전까지의 결과] vs. [3개 전까지의 결과 + 1개 전 "점수"]
		 * 둘을 비교해서 연달아 3번 이동한 경우를 아예 고려하지 않아 버리는 것
		 * */
		
	} //main
	
	static int findMax(int n) {
		if (n <= 0) {
            return 0; // 인덱스가 0 이하인 경우 처리
		}
		if (dp[n] == 0) {
			//2칸 이동한 경우 vs. 2칸 이동 후 1칸 이동한 경우
			dp[n] = Math.max(findMax(n-2), findMax(n-3)+ stairs[n-1]) + stairs[n];
		}
		return dp[n];
	}

} //class
