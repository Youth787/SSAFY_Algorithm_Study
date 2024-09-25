import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

		int arr[] = new int[N]; // 초밥 저장할 배열열
		boolean sushi[]; // 이 초밥 먹었는지 확인하는 배열

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int start = 0;
		int end = start + 1;
		int res = Integer.MIN_VALUE; // 가능한 다양한 종류의 초밥을 먹을 수 있는 경우의 수

		while (true) {
			if (start == N) {
				break;
			}
			int len = 1;

			sushi = new boolean[d + 1];
			sushi[arr[start]] = true;

			// 현재 start에 대해서 얼마만큼 먹을 수 있는지 계산하기
			while (true) {
				if (len == k) {
					sushi[c] = true;
					int cnt = 0;
					for (int i = 0; i <= d; i++) {
						if (sushi[i]) {
							cnt++;
						}
					}
					res = Math.max(res, cnt);
					start++; // start++해주고

					if (start == N - 1) {
						end = 0;
					} else {
						end = start + 1;
					}
					break; // 다음으로넘어가기

				}
				sushi[arr[end++]] = true;
				len++;
				if (end == N) {
					end = 0; // 다시 처음부터 시작
				}
			}
		}
		System.out.println(res);
	}
}
