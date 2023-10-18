import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//2023.10.17.DP2
//https://dingdingmin-back-end-developer.tistory.com/entry/백준-18427자바-java-함께-블록-쌓기
public class Main18427_함께블록쌓기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //학생수
		int m = Integer.parseInt(st.nextToken()); //학생마다 최대 블록개수 
		int h = Integer.parseInt(st.nextToken()); //목표높이 
		
//		int[][] block = new int[n][m];
//		for (int i=0; i<n; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j=0; j<m; j++) {
//				if (st.hasMoreTokens()) block[i][j] = Integer.parseInt(st.nextToken());
//			}
//			System.out.println(Arrays.toString(block[i]));
//		}
		
		//각 행마다 최대 1개의 블록 사용 가능 (안 써도 됨) 
		//정확히 높이 h를 달성하는 경우의 수를 10007로 나눈 나머지를 구하기 
		
		//boolean[] visited = new boolean[n]; //학생별 사용했는지 체크 
		//int[][] dp = new int[n][h]; //학생 한명 추가할 때마다 높이 달성 가능한 가짓수 
		
		int[][] dp = new int[n+1][1001];
		List<Integer>[] list = new ArrayList[n+1];
		 
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
 
        for(int i=0; i<=n; i++){
            dp[i][0]=1;
        }
 
        for(int i=1; i<=n; i++){
            for(int j=1; j<=h; j++){
                for(Integer integer: list[i]){
                    if(j>=integer){
                        dp[i][j] += dp[i-1][j-integer];
                        dp[i][j] %=10007;
                    }
                }
                dp[i][j] += dp[i-1][j];
                dp[i][j] %=10007;
            }
        }
        System.out.println(dp[n][h]);
		
	}
	
}