import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static int N;
	static int count=0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		nqeen(0);
		System.out.println(count);
	}

	public static void nqeen(int D) {
		if (D == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[D] = i;
			if (check(D)) 
				nqeen(D + 1);
		}
	}

	public static boolean check(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[i] == arr[col]) 
				return false;
			if (Math.abs(i - col) == Math.abs(arr[i] - arr[col])) 
				return false;
		}
		return true;
	}
}
