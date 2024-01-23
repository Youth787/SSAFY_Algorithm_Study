import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrintStar {
	static String[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = n * 2 - 1;

		map = new String[n][m];
		for (int i = 0; i < n; i++) Arrays.fill(map[i], " ");

		partition(0, n - 1, n);

		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(map[i]).replaceAll(", ", "").substring(1, m + 1));
		}
	}

	private static void partition(int row, int col, int n) {
		if (n == 3) {
			map[row][col] = "*";
			map[row + 1][col - 1] = map[row + 1][col + 1] = "*";
			map[row + 2][col - 2] = map[row + 2][col - 1] = map[row + 2][col] = map[row + 2][col + 1] = map[row + 2][col + 2] = "*";
		}
		else {
			int div = n / 2;
			partition(row, col, div);
			partition(row + div, col - div, div);
			partition(row + div, col + div, div);
		}
	}
}
