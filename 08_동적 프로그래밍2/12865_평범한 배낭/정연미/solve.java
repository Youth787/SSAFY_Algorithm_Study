package DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 
//각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 
//아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 
//준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값

//첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다. 
//두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.

//4 7
//6 13
//4 8
//3 6
//5 12

public class 평범한배낭 {
	static int[][] arr, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		arr = new int[N+1][2];
		
		for(int i =1; i<=N; i++) {
			input = br.readLine().split(" ");
			arr[i][0]= Integer.parseInt(input[0]);
			arr[i][1]= Integer.parseInt(input[1]);
		}// 입력받기 완료
		
		dp = new int[N+1][K+1];
		System.out.println(DFS(N,K));
		
 	}// main end 
	public static int DFS(int idx, int k) {
		if(idx<=0) 
			return 0;
		
		if(dp[idx][k]==0) {
			if(arr[idx][0]>k) dp[idx][k] = DFS(idx-1,k);
			else dp[idx][k] = Math.max(DFS(idx-1,k), DFS(idx-1,k-arr[idx][0])+arr[idx][1]);
		}
		return dp[idx][k];
	}
}
