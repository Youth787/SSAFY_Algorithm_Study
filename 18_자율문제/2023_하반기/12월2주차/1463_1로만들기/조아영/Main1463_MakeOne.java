import java.util.*;

public class Main1463_MakeOne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int[] dp = new int[x+1];
		Arrays.fill(dp,987654321); //최솟값 구해야하니까 큰 수를 디폴트로 
		dp[1] = 0; 
		if (x>1) dp[2] = 1;
		if (x>2) dp[3] = 1;
		
		for (int i=4; i<=x; i++) {
			if (i%2==0) dp[i] = Math.min(dp[i],dp[i/2]+1);
			if (i%3==0)	dp[i] = Math.min(dp[i],dp[i/3]+1);
			dp[i] = Math.min(dp[i],dp[i-1]+1);
		}
		System.out.printf("%d",dp[x]);
		
	}
}
