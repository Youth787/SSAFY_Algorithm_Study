// https://velog.io/@qwerty1434/%EB%B0%B1%EC%A4%80-18427%EB%B2%88-%ED%95%A8%EA%BB%98-%EB%B8%94%EB%A1%9D-%EC%8C%93%EA%B8%B0
// 뭔가 그나마 이해가 더 잘되는 듯한 풀이

import java.util.*;
import java.io.*;

public class Main {
	static final int MOD = 10007; //우리가 dp에 저장하고, 답으로 가져와야 하는 건 경우의 수를 10007로 나눈 나머지값. 이걸 그냥 따로 상수로 빼뒀다
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if(st.hasMoreTokens()) {					
				int j = 0;
				while(st.hasMoreTokens()) {
					board[i][j++] = Integer.parseInt(st.nextToken());					
				}
			}
		} //입력은 풀이1과 비슷
		
		int[][] dp = new int[N+1][H+1]; //이것도
		for (int i = 0; i <= N; i++) {
			dp[i][0] = 1;
		} //비슷함
		
		for (int i = 1; i <= N; i++) { //학생 도는 for문
			for (int j = 1; j <= H; j++) { //높이 도는 for문
				dp[i][j] = dp[i-1][j]; // (i-1)번째 학생이 높이 j만큼 쌓는 경우의 수를 불러와 
        // = i의 블록을 사용하지 않을 때의 경우의 수
				for (int k = 1; k <= M; k++) { // i번째 학생의 k번째 블록을 사용한다는 for문
					int block = board[i-1][k-1]; // 현재 k번째 블록의 높이 = board는 인덱스 0부터 값을 적어뒀으니까
					if(block == 0) continue; // board 의 사이즈는 학생이 최대로 가질 수 있는 블록 수만큼 만들어 놨고, 블록은 높이가 자연수이므로 0일 수 없고.
          //따라서 현재 block이 0이라는 것은 그 학생이 가진 블록이 더 없다 = continue함으로써 넘어가라.. 계속 넘어가다 보면 높이 도는 for문이 이제 다음 값으로 넘어가겠지..
					if(j-block >= 0) { // 지금 고려하고 있는 블록 높이 <= 현재 dp가 다루는 높이 j (=지금 그 블록을 쌓을 수 있다면?)
						dp[i][j] += dp[i-1][j-block]; // 현재 dp값(경우의 수)에 (i-1) 번째 학생이 (현재 dp가 다루는 높이-지금 블록 높이)를 쌓았을 때의 경우의 수를 넣는다
						dp[i][j] %= MOD; //나머지 값을 저장하겠다
					} // 더 블록 쌓을 수 있는지 확인하는 조건문
				} // i번째 학생의 k번째 블록을 사용한다는 for문 끝
			} // 높이 도는 for문의 끝
		} //학생 도는 for문의 끝
    
		System.out.println(dp[N][H]);
	
	}
}
