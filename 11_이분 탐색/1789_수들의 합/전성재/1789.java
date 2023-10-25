import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long s = Long.parseLong(br.readLine());
		long sum = 0;
		int cnt = 0;
		int n = 1;
		while (s >= sum) {
			sum += n;
			cnt++;
			n++;
		}
		System.out.println(cnt - 1);
	}
}
