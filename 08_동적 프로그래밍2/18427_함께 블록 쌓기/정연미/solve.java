import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//3 3 5
//2 3 5
//3 5
//1 2 3

public class 함께블록쌓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int H = Integer.parseInt(input[2]);
		
		List<Integer>[] list = new ArrayList[N+1];
 		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			input = br.readLine().split(" ");
			for(int j=0; j<input.length; j++) {
				list[i].add(Integer.parseInt(input[j]));
			}
		} // 입력받기 완료 
 		
 		int[][] dp = new int[N+1][H+1];
 		
 		for(int i=0; i<=N; i++) // 0개를 선택 가능성은 1
 			dp[i][0] = 1;
 		
 		for(int i=1; i<=N; i++) {
 			for(int j=1; j<=H; j++) {
 				for(int x : list[i]) 
 					if(j>=x) dp[i][j] += dp[i-1][j-x] % 10007; // 블럭을 선택할 경우 
 				dp[i][j] += dp[i-1][j]% 10007; // 블럭 선택 안할 경우 
 			}
 		}
 		
 		System.out.println(dp[N][H]% 10007);
 		
	}//main end 
}
