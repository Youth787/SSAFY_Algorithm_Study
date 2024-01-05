import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int arr[] = { 3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1 };
		int score = 0;
		int[] sarr = new int[s.length()]; // 획을 저장할 배열

		for (int i = 0; i < sarr.length; i++) {
			sarr[i] = arr[s.charAt(i) - 'A'];
		}
		for (int i = 0; i < sarr.length; i++) {
			score += sarr[i];
			score %= 10;
		}
		if (score % 2 == 0) {
			System.out.println("You're the winner?");
			
		} else {
			System.out.println("I'm a winner!");
		}
	}
}
