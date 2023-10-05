import java.util.Arrays;
import java.util.Scanner;

public class 동프2_Main9084_동전 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); //테케 수 
		for (int t=1; t<=tc; t++) { //테케 반복문 
			int n = sc.nextInt(); //동전 가짓수 
			int[] coin = new int[n]; //동전 배열 
			for (int i=0; i<n; i++) {
				coin[i] = sc.nextInt();
			}
			int m = sc.nextInt(); //만들어야 할 금액 
			
			int[] dp = new int[m+1]; 
			
			for (int i=0; i<n; i++) { //동전종류 n가지로 
				for (int j=1; j<=m; j++) { //1원부터 m원까지 볼거야 
					if (coin[i]<j) dp[j] = dp[j] + dp[j-coin[i]]; //coin[i]만큼 빽해서 그 값을 더해 
					else if (j==coin[i]) dp[j] = dp[j] + 1; //현재금액 j가 현재 동전액면가 coin[i]와 같으면 +1
				}
			}
			//System.out.println(Arrays.toString(dp));
			System.out.println(dp[m]);
		} //테케 
		
	}
}
