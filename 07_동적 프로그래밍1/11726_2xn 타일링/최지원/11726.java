import java.util.Scanner;

public class Main {
	
	public static int [] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //n은 1부터 1000까지
		
		dp = new int[1001]; //n과 상관없이 그냥 최대경우까지 만들어둠. 이렇게 하면 n이 1이어도 그냥 dp[2] 저장해둬도 상관없움
		
		dp[1]=1; //1부터 값 넣음
		dp[2]=2;
		for (int i = 3; i<=n; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007; //이런 경우는 보통 나눈 값을 dp에 저장
		}
		
		System.out.println(dp[n]);
		
	}
	

}
