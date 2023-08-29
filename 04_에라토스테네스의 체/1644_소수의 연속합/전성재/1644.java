import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer> isPrime = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		boolean prime[] = new boolean[n + 1];
		prime[0] = true;
		prime[1] = true;
		// 소수를 구하는 식
		for (int i = 2; i * i <= n; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= n; j += i) {
					prime[j] = true;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!prime[i]) {
				isPrime.add(i);
			}
		}
		int start = 0; // 시작위치
		int end = 0; // 끝 위치
		int sum = 0;
		int count = 0;
		
		while (true) {
			if (sum > n) {
				sum -= isPrime.get(start++);
			} else if (end == isPrime.size()) {
				break;
			} else {
				sum += isPrime.get(end++);
			}
			if (n == sum) {
				count++;
			}
		}
		System.out.println(count);
	}
}
