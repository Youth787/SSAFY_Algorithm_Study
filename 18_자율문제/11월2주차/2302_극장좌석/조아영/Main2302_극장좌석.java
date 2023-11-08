import java.util.Scanner;

public class Main2302_극장좌석 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//좌석개수
		int m = sc.nextInt();//고정석개수
		int[] vip = new int[m+1];

		for (int i=1; i<=m; i++) {
			vip[i] = sc.nextInt();
		}
		
		int[] dp = new int[40]; //고정석이 없을 경우 앉을 수 있는 경우의 수 
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2; 
		for (int i=3; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		//고정석이 있으면 걔를 기준으로 양옆 사람들의 가짓수를 구해야 함 
		
		long answer = 1; 
		for (int i=1; i<=m; i++) {
			int people = vip[i]-vip[i-1]-1; //해당 고정석 전까지의 인원수를 구해서 
			answer *= dp[people]; //그 인원수로 만들수있는 경우의수를 곱해줌 
		}
		answer *= dp[n-vip[m]];
		
		System.out.println(answer);
		
	}
	
}
