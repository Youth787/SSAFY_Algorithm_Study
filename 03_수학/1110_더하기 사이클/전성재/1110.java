import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int c = n;
		int cnt = 0;
		while (true) {
			cnt++;
			int n1 = n / 10;
			int n2 = n % 10;
			n = (n2 * 10) + ((n1 + n2) % 10);

			if (c == n) {
				break;
			}

		}
		System.out.println(cnt);
	}

}
