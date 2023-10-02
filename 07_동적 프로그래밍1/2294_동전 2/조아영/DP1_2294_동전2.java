import java.util.Arrays;
import java.util.Scanner;

public class DP1_2294_동전2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //동전 종류 수 
		int k = sc.nextInt(); //만들어야하는 금액 
		
		int[] money = new int[n]; 
		for (int i=0; i<n; i++) {
			money[i] = sc.nextInt();//동전 종류 입력 받음 
		}
		
		int[] dp = new int[k+1];
		Arrays.fill(dp, 999999);
		dp[0]=0;
		for (int i=1; i<=k; i++) {//k원까지 경우의 수 구할 거야 
			for (int j=0; j<n; j++) { //동전 종류 하나씩 늘려가면서 
				if (money[j]<=i) dp[i]=Math.min(dp[i], dp[i-money[j]]+1);
			}
		}	
		
		//아니면 아래처럼 해도 됨 
//		for (int i=0; i<n; i++) {
//			for (int j=money[i]; j<=k; j++) {
//				dp[j] = Math.min(dp[j], dp[j-money[i]]+1);
//			}
//		}
		
		System.out.println(dp[k]!=999999?dp[k]:-1);
	}

}
