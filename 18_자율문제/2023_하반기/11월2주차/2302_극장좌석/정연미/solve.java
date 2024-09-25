package _11월2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2302_극장좌석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[M+1];
		for(int i=1; i<=M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} // 입력 받기 
		
		int count =1;
		int[] dp = new int[45];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2; 
		// 좌석이 0개, 1개, 2개 일때 만들 수 있는 경우의 수. 
		
		for(int i=3; i<45; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		} // 좌석에 개수에 따른 경우의 수는 피보나치를 따른다. 
		
		// M까지 입력받은 배열에서 각각 덩어리 크기에 해당하는 값을 누적 곱한다. 
		for(int i=1; i<=M; i++) {
			count *= dp[arr[i]-arr[i-1]-1];
		}
		
		count *= dp[N-arr[M]];
		System.out.println(count);
		
	} //main end
}
