import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


//1명당 1개의 블록만 가능
//블록을 쌓지 않아도 된다!!
//dp로 풀수있다!!
//1 번째 사람이 블록을 쌓는다면(2, 3, 5를 가지고있음) - 안쌓은 것도 1로 침 (총 가짓수 세는거임)
//  0 1 2 3 4 5 
//  1 0 1 1 0 1 으로 채울 수 있고 두번째사람이 채운다면 (3, 5 가짐)
//  1 0 1 2 0 3 으로 채울 수 있따! >>3일때 자신이 가진 블록수1개+전사람3만든경우의수1 = 2!! 세번째 사람이 채운다면 ? (1, 2, 3가짐)
//  1 1 3 4 3 6 >> 5일때 자신이 가진 같은값 블록수0 + 전 사람이 5를 만든 경우의수 3 + (자신이 가진 블록값 + 전사람이 만든 블록경우의수3) = 6임
public class bj18427 {
	static int n, m, h;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n + 1][1001];
		list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int temp = st.countTokens();
			for (int j = 0; j < temp; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= h; j++) {
				for (Integer integer: list[i]) {
					if (j >= integer) { // 내가 가진 블록값 + 이전까지 만든 블록의 값을 더해서 경우의 수를 만들 수 있음!!
						dp[i][j] += dp[i - 1][j - integer]; // 그래서 이전까지 만든 경우의 수를 더한다.
						dp[i][j] %= 10007;
					}
				}
				dp[i][j] += dp[i - 1][j]; // 이전까지 값이 만들어진 경우를 더한다.
				dp[i][j] %=10007;
			}
		}
	
		
		System.out.println(dp[n][h]);
		
	}

}

//https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-18427%EC%9E%90%EB%B0%94-java-%ED%95%A8%EA%BB%98-%EB%B8%94%EB%A1%9D-%EC%8C%93%EA%B8%B0
