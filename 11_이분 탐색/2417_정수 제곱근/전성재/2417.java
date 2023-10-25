// 이분 탐색
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		System.out.println(bSearch(n));
	}

	static long bSearch(long n) {
		long start = 0;
		long end = n;
		long result = 0;

		while (start <= end) {
			long mid = (start + end) / 2;
			if (n <= (long) Math.pow(mid, 2)) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}
}

// 함수 이용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long q = (long)Math.sqrt(n);

        if((q*q) < n) q++;

        System.out.println(q);
    }
}
