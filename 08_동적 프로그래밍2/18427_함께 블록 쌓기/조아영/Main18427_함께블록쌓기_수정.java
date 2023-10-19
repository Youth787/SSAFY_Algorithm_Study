import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2023.10.17.DP2
public class Main18427_함께블록쌓기_수정 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //학생수
		int m = Integer.parseInt(st.nextToken()); //학생마다 최대 블록개수 
		int h = Integer.parseInt(st.nextToken()); //목표높이 
		
		int[][] block = new int[n+1][m+1];
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=m; j++) {
				if (st.hasMoreTokens()) 
				block[i][j] = Integer.parseInt(st.nextToken()); //학생마다 갖고있는 블럭 수 입력받음 
			}
			//System.out.println(Arrays.toString(block[i]));
		}
		
		//각 행마다 최대 1개의 블록 사용 가능 (안 써도 됨) 
		//정확히 높이 h를 달성하는 경우의 수를 10007로 나눈 나머지를 구하기 
		
		int[][] dp = new int[n+1][h+1];
        for(int i=0; i<=n; i++){
            dp[i][0]=1; //높이 0을 만들 수 있는 경우의 수=1 초기값 지정해둠 
        }
		
		for (int i=1; i<=n; i++) { //학생 한명씩 추가 
			for (int j=1; j<=h; j++) { //높이 1씩 추가 
				for (int k=1; k<=m; k++) { //블록 1개씩 추가 
					//i번째 학생의 블록이 남아있음 & 현재 목표 높이 j가 그 블록 높이보다 높음 : 그 블록 사용 가능 
					if (block[i][k]!=0 && j>=block[i][k]) { 
						dp[i][j] = dp[i][j] + dp[i-1][j-block[i][k]]; //앞서 구했던 경우의 수 + 이번 블록 사용할 수 있는 경우의 수를 더함  
						dp[i][j] = dp[i][j] % 10007; //우리는 10007로 나눈 나머지를 구해야 함 
					}
				}
				dp[i][j] += dp[i-1][j]; //추가할 블록 없으면 그냥 앞서 구한 경우의 수를 그대로 갖고 내려감 
                dp[i][j] %= 10007; //이것도 10007로 나눈 나머지를 구해줘야 해 
			}
		}
		
		System.out.println(dp[n][h]);
		
	}
	
}
