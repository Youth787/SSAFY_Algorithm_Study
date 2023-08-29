import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		boolean isPrime[] = new boolean[n + 1];
		isPrime[1] = true;
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				continue;
			}
			for (int j = i * 2; j <= n; j += i) {

				isPrime[j] = true;

			}

		}
		
		for (int i = m; i <= n; i++) {
			if (isPrime[i]==false) {
				System.out.println(i);
			}
		}
	}
}
