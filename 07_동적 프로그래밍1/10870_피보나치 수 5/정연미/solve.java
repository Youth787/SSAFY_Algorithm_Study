import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수5_10870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(pivo(N));
	}

	public static int pivo(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		else return pivo(n - 1) + pivo(n - 2);
	}
}
