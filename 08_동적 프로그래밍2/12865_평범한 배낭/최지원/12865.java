package p12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, k;//물건 n개, 최대 감당 무게 k
	static int [][] info;//각 물건 무게w와 가치v
	static int [][] dp;// 그 수까지 담았을 때 최대 가치를 저장
	
	//물건 n개는 각각 무게w와 가치v를 가짐
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		//첫 줄에 물건 수 n과 최대 무게 k
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//물건 수
		k = Integer.parseInt(st.nextToken());//최대 견디는 무게
		info = new int [n+1][2]; //n개의 물건에 대한 무게와 가치를 2차원 배열에 한번에 저장
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());//물건 무게
			info[i][1] = Integer.parseInt(st.nextToken());//물건 가치
		}//입력 완
		
		dp = new int [k+1][n+1];//무게 k까지의, 물건 n까지 고려했을 때의 가치 저장 
		
		System.out.println(bag(k));
			
	}//main
	
	public static int bag(int k) {
		for (int i = 1; i <= k; i++) {//무게를 고려하는 for문: 1부터 k까지 돌아		
			for (int j = 1; j <= n; j++) {//그 안에 n개의 물건을 차례로 고려하는 for문:1부터 돈 이유는 물건을 아예 안 넣은 상황(0)도 이용하기 위해
				if (info[j][0] <= i) {//물건의 무게가 가방 안에 들어갈 수 있다면
					dp[i][j] = Math.max(dp[i][j-1], dp[i-info[j][0]][j-1]+info[j][1]);
					//dp[i][j-1] : 그 물건을 안 넣거나, dp[i-info[j][0]][j-1]: (들어갈 공간 확보+) 그 물건 전까지 고려했을 때+ info[j][1]: 새로 넣는 물건 가치의 최대 비교 
				} else {//물건을 못 넣는다면
					dp[i][j] = dp[i][j-1];//물건을 못 넣는다면 그 전 무게까지의 가치 최대값을 그대로 가져와 저장.
				}
			}//물건 고려하는 for문
		}//무게 고려 for문		
		return dp[k][n];
	}//bag
}//class
