//완성못한 코드..그냥 이런 식으로 풀고 싶었다...고런거
package p18427_함께블록쌓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//학생 당 블록 하나만 쓰거나, 아예 안쓰거나.
public class Main {
	static int n, m, h;//n은 학생수, m은 학생마다 최대로 가진 블록 수, h는 목표 탑 높이
	static int [][] info;//학생마다 가진 블록 높이들 저장
	static int [][] dp;//쌓을 수 있는 경우의 수를 10007로 나눈 나머지 저장..전에 dp 처음 블록문제 풀때고 dp에 미리 나머지로 저장 안해주면 틀렸음
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());//학생 수
		m = Integer.parseInt(st.nextToken());//최대 블록 수
		h = Integer.parseInt(st.nextToken());//목표 높이
		info = new int [n][m];
		//블록 있는만큼 저장
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());//블록 하나는 갖고 있겠지
			for (int j = 1; j < m ; j++) {
				if (st.hasMoreTokens()) { //StringTokenizer클래스의 메서드 설명 ( https://breakcoding.tistory.com/194 )
					info[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}//정보 저장
		
		dp = new int [h+1][n+1]; //중요한 건 학생 한명씩 도는 거랑, 높이까지의 경우의 수를 찾는 것 
		//높이 0을 만들 수 있는 
		
		
		for (int i = 0; i <= h; i++) { //높이 h까지 도는 for문
//			int tmp = 0;//지금 쌓은 블록 높이를 저장
			for (int j = 1; j <= n; j++) { //학생 n명까지를 도는 for문
				dp[0][j-1] = 1;
				for (int p = 0; p < m; p++) { //학생이 가진 최대 m개의 블록을 도는 for문
					if (info[j][p] != 0) { //블록높이 값이 0이 아니면(다음 블록을 가지고 있으면)
						dp[i][j] = (dp[i][j] + dp[i-info[j][p]][j-1]) % 10007;
					}
				}
			}
		}
		
		System.out.println(dp[h][n]);

	}//main
}//class
