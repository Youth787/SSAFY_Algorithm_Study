import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());

		arr = new long[64];
		arr[0] = 1;
		for (int i = 1; i < 64; i++) {
			arr[i] = arr[i - 1] * 2;
		}
		System.out.println(sol(N));
	}

	public static int sol(long x) {
		if (x == 1)
			return 0;
		for (int i = 0; i < 64; i++) {
			if (arr[i] >= x)
				return 1 - sol(x - arr[i - 1]);
		}
		return 0;
	}
}
