import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	static int n;
	static int m;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		n = Integer.parseInt(st.nextToken()); // 점의 개수
		m = Integer.parseInt(st.nextToken()); // 선분의 개수
		arr = new long[n]; // 점의 좌표를 담을 배열

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr); // 배열을 크기 순으로 정렬

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int result = binarySearch(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			sb.append(result).append('\n');
		}

		System.out.println(sb);

	}

	static int binarySearch(int x, int y) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (arr[mid] > y) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		int endIndex = end + 1; // 선분 위의 숫자 중에서 가장 큰 숫자를 가진 인덱스

		start = 0;
		end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (arr[mid] < x) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		int startIndex = start; // 선분 위의 숫자 중에서 가장 작은 숫자를 가진 인덱스

		return endIndex - startIndex; // 둘의 차이를 계산해서 개수 계산!
	}

}
