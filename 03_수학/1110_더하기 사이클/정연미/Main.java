import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int count = 0;
		int new_N = 0;

		int ten = N / 10;
		int one = N % 10;

		while (true) {
			new_N = one * 10 + (ten + one) % 10;
			count++;

			if (N == new_N) {
				break;
			}
			ten = new_N / 10;
			one = new_N % 10;
		}

		System.out.println(count);

	}// main end
}
