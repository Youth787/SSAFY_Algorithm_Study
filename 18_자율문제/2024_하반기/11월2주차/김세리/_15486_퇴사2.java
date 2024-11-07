package _20241113;

import java.util.*;
import java.io.*;

public class _15486_퇴사2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 수익은 N+1 날에 결정된다
		// dp로 구하기 위해서 범위 예외가 발생하지 않도록 counsel 표 크기도 N+1로 설정해야 한다
		int [][] counsel = new int[N+2][2];
		for(int i=1;i<N+1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			counsel[i][0] = Integer.parseInt(st.nextToken());
			counsel[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+2];
		
		// 최대 수익 변수를 이용해서 i시점의 최대수익을 저장한다
		// i시점에 저장된 수익은 i날에 받을 수 있는 수익을 의미한다
		// 즉, i시점 전까지 수행한 일들을 통해서 받을 수 있는 최대수익이다
		// (i날에 할 수 있는 일과는 무관하단 의미)
		int maxIncome=0;
		
		for(int i=1;i<N+2;i++) {
			
			// dp[i]에는 i전날까지 일한걸 토대로 i날 받을 수 있는 최대수익이 계산되어 있다
			maxIncome = Math.max(maxIncome,dp[i]);
			// endDay: i날에 할당된 일을 시작해서 끝내고, 수익을 받는 날(즉, 수익이 계산되는 시점)
			int endDay = i+counsel[i][0];
			
			if(endDay <= N+1) {
				// 기존에 계산된 수익과 i시점 일을 했을 경우 발생되는 수익을 비교하여
				// 수익이 더 큰 경우의 수를 시행한다
				dp[endDay] = Math.max(dp[endDay],maxIncome+counsel[i][1]);
			}
		}
		
		System.out.println(maxIncome);
	}
}
