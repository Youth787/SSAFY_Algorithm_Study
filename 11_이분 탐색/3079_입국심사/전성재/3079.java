import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n;
	static long m, max;
	static int[] arr;
	static long result = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 심사대의 개수
		m = Integer.parseInt(st.nextToken()); // 친구들의 명수
		arr = new int[n]; // 심사를 하는데 걸리는 시간을 담기

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]); // 가장 긴 심사 시간
		}
		Arrays.sort(arr);

		solve();

		System.out.println(result);
	}

	private static void solve() {
		long low = 0;
		long high = m * max; // 최악의 시간

		while (low <= high) {
			long mid = (low + high) / 2;
			long sum = 0;
			for (long index : arr) {

				if (sum >= m) {
					break;
				}

				sum += mid / index; // mid 초 내에 해당 심사대에서 심사받을 수 있는 최대 인원 수

			}
			if (sum >= m) {
				high = mid - 1;
				result = Math.min(mid, result);
			} else {
				low = mid + 1;
			}
		}
	}
}
