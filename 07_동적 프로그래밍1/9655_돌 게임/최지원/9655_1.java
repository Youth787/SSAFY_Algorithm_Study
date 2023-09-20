import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[문제] 두 사람이 돌 n개를 번갈아가며 1 또는 3개 가져갈 때 마지막 돌을 가져가는 사람이 누구인지
//[출력] 상근이 SK, 창영 CY 
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); //돌 개수
		
		if (n%2 ==1) System.out.println("SK");
		else System.out.println("CY");

		//돌 1개일때 상근. 2개일때 창영, 3개일때 상근... 반복

		/* 또는 dp 상향식으로 int[] dp = new int [1001] (최대 돌 1000개), dp[1] =1 ; dp[2] = 2; dp[3] = 1; 
  			for ( i from 4 to n ) dp[i] = Math.min(dp[i-1],dp[i-3])+1; } 
     			if (dp[n] % 2 == 0) 이면 sk, 아니면 cy
     		*/
	}

}
test
