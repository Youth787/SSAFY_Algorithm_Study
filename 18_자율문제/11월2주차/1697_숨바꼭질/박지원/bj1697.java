import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //수진이 위치
		int k = Integer.parseInt(st.nextToken()); // 동생 위치
		//수빈이가 x에있을때 걷는다면 1초후에 x-1혹은 x+1
		//순간이동하면? 1초후에 x * 2에 있음
		//동생을 찾을 수 있는 가장 빠른시간은?!
		//dp로 풀어보자꾸나
		int[] dp = new int[200001]; // dp는 0 ~ k + 1까지의 위치를 나타낸다!!!! dp[i]는 위치i에서의 최소값을 담을거임
		//자꾸 arrayindexoutofbounds떠서 걍 k가능한 범위 이상으로 잡아둠.
		
		dp[n * 2] = 1; // 일단 내 위치에서 2배는 1으로 가능하니까 두고
		if (n < k) {
			//왼쪽으로 먼저 이동해보자
			for (int i = 1; i <= n; i++) { // 0~ 수빈이의 위치는 순간이동 불가능함. 그래서 1씩 더해준값 & /2, +1했을때랑 비교한 값이 답
				dp[n - i] = i;
				int a = 2 * (n - i);
				if (a <= k + 1) { // 2배한 값이 k + 1안에 있다면 미리 담아주자
					if (a <= n) { // n보다 작을때는 자기자신이랑 2배해서 1더한값 중 작은값 고르기
						dp[a] = Math.min(dp[a], dp[n - i] + 1);
					} else {
						dp[a] = dp[n - i] + 1;
					}
						
				}
			}
			
			// 이제 오른쪽으로 이동해보자
			for (int i = 1; i <= k - n; i++) { // 수빈위치 + 1~k까지는 순간이동이 가능함. 그래서 비교를 해주기
				if ((n + i) % 2 == 0) { // 짝수일땐 /2에서 내 자신이 채워지니까 내자신이랑 나보다 작은애를 비교하기
					dp[n + i] = Math.min(dp[n + i - 1] + 1, dp[n + i]);

				} else { // 홀수일때는 내 아래사람(짝수)랑 내 윗사람(짝수)랑 비교하기
					dp[n + i] = Math.min(dp[n + i - 1] + 1, dp[n + i + 1] + 1);
				}
				if (2 * (n + i) <= k + 1) // 여기도2배한게 k+1보다 작거나 같으면 2배처리 해줘!!
					dp[2 * (n + i)] = dp[n + i] + 1;
			}
		} else { // 수진이가 동생보다 오른쪽에 위치할때(x좌표생각)는 그냥 빼주면 됨
			dp[k] = n - k;
		}

		System.out.println(dp[k]);
	}
}
