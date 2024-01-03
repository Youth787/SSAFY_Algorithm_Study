import java.io.*;
import java.util.*;

public class Main {
	static int n, d, k, c;
	static int[] sushi;
	static int[] eated;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		d = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		c = Integer.valueOf(st.nextToken());
		sushi = new int[n];
		eated = new int[d + 1];
		
		// 스시 종류 번호 배열에 넣기
		for(int i = 0; i < n; i++) {
			sushi[i] = Integer.valueOf(br.readLine());
		}
		
//		1) 처음 0번부터 k개수만큼 먹었을 때의 초기화
		int count = 0;
		for(int i = 0; i < k; i++) {
			if(eated[sushi[i]] == 0) {
				count++;
			}
			
			eated[sushi[i]]++;
		}

		int maxLen = count;
//		2) 1번부터 n-1번까지 start만 이동시키면 k는 고정이기 때문에 end를 활용할 필요가 없다.
		// i : start
		for(int i = 1; i < n; i++) {
			
			if(maxLen <= count) {
				if(eated[c] == 0) { // 아직 쿠폰초밥을 안먹은 상태
					maxLen = count + 1;
				}
				else { // 아직 쿠폰초밥을 먹은 상태
					maxLen = count;
				}
			}
			
			// end 이동
			int end = (i + k - 1) % n;
			if(eated[sushi[end]] == 0) {
				count++;
			}
			eated[sushi[end]]++;
			
			// start 이동
			eated[sushi[i - 1]]--;	// start점 한 칸 이동했으니 이전의 초밥 제거
			if(eated[sushi[i - 1]] == 0) {
				count--;
			}
		}
		
		System.out.println(maxLen);
	}
}
