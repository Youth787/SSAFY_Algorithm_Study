import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int n1 = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = n1;
		for (int i = n; i <= n1; i++) {
			boolean check = true;

			if (i == 1) {
				continue; // 1은 소수가 아니라서 넘어간다
			}

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					check = false;
					break;
				}

			}

			if (check) {
				sum += i;
				min = Math.min(i, min);

			}

		}

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}

	}

}
