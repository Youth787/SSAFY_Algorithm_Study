package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2417_정수제곱근 {
	static long n, result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());

		binarySearch();
		System.out.println(result);
	}// main end

	public static void binarySearch() {
		long st = 0;
		long ed = n;
		long mid = 0;

		while (st <= ed) {
			mid = (st + ed) / 2;
			if (Math.pow(mid, 2) >= n) {
				result = mid;
				ed = mid - 1;
			} else
				st = mid + 1;
		}
	}// method end
}
