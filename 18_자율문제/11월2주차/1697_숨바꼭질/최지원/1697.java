package p1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//수빈의 위치 N(0 ≤ N ≤ 100,000), 동생의 위치 K(0 ≤ K ≤ 100,000)
//1초마다 이동: 수빈이 걷는다면 +-1씩 이동. 순간이동하면 *2 이동
public class Main {
	
	static int [] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//수빈의 위치
		int k = Integer.parseInt(st.nextToken());//동생의 위치
		
		int ans = 0;
		
		if (k <= n) {
			//동생이 수빈이보다 왼쪽에 있다면 -1로만 이동 가능
			ans = n - k;
		} else {
			//동생이 수빈이보다 오른쪽에 있다면 +1 -1 *2 다 가능
			dp = new int [100001];//위치가 0부터 100000까지 가능 
			//k+1로 하려고 했는데 그럼 동생보다 더 뒤로 갔다가 -해서 돌아오는 경우를 못셈
			//최종 목표는 [k]까지 도달
			
			//수빈이 위치까지 갈 수 있는 최소 시간 dp에 저장
			for (int i= 0; i <= n ; i++) {
				//
				dp[i] = n-i;
			}//이걸 활용해서 n에서 k까지 갈 수 있는 최소 시간을 구하겠다
			
//			System.out.println(Arrays.toString(dp));
			
			for (int i = n+1; i <= k; i++) {
				int min = 987654321;
				if (i%2==0) min=dp[i/2]+1;//2로 나눠지면, 반값위치(i/2)에서 순간이동에 사용한 1초를 더한 값
				else min = Math.min(dp[(i-1)/2]+2, dp[(i+1)/2]+2);//+-1한 위치(+1초)에서 순간이동(+1초)했을 때의 값 비교
				
				dp[i] = Math.min(min, dp[i-1]+1);//최종적으로 여기서 구한 최소시간 min과 i-1위치에서 뭔 짓을 한 +1 시간 비교
			}
			
			ans = dp[k];
		}
		
		System.out.println(ans);		
	}//main

}//class
//5-2배 10- 마이너스1 9- 2배 18- 마이너스 117 (동생보다 더 뒤로 갔다가 돌아오는 최적해가 존재할 수 있음(?))
