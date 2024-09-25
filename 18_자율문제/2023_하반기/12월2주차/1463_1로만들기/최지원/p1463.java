import java.util.Arrays;
import java.util.Scanner;

/*
 * 3으로 나누거나 2로 나누거나 1을 빼거나 1을 만드는 연산 횟수 최소값
 * */
public class p1463 {
	
	static int n;
	
	static int [] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dp = new int [n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		dp[1] = 0;
		
		for (int i = 2; i <= n; i++) {
			//6 => (2일때*3) (3일때*2) (7일때-1)
			if (i%3 == 0) {				
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			if (i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);				
			}
			dp[i] = Math.min(dp[i], dp[i-1]+1);				
			
		}
		
		System.out.println(dp[n]);
	}//main
}//class
