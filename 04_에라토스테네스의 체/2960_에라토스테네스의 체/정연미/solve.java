package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에라토스테네스의체 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N까지의 정수에서
		int K = Integer.parseInt(st.nextToken()); // k번째 지워지는 수

		boolean[] primearray = new boolean[N + 1]; // N까지의 정수를 배열로 나타낸다.
		int result = primecheck(primearray, N, K);
		System.out.println(result);

	}// main end

	static int primecheck(boolean[] array, int N, int K) {
		array[0] = true;
		array[1] = true;
		// 나중에 false되는 애들을 소수라고 출력할 예정이기에 소수가 아닌 것은 모두 true 처리.

		int check_count = 0; // 지워지는 숫자 순서
		for (int i = 2; i <=N; i++) {
			if (!array[i]) {
				check_count++;
				if (check_count == K) {
					return i;
				}
				for (int j = i * i; j <= N; j += i) { // i의 배수가 되는 애들은 모두 true(소수가 아니다)로 만들어주기.
					if (!array[j]) {
						array[j] = true;
						check_count++;
					}
					if (check_count == K) {
						return j;
					}
				}
			}
		}
		return 0;
	}// method end
}

//에라토스테네스의 소수 찾기
//소수가 되는 수의 배수를 지우면 남은 건 소수가 된다는 알고리즘
//i=2 일 때, 2를 제외한 2의 배수는 모두 2로 나뉘니 소수가 아니다.