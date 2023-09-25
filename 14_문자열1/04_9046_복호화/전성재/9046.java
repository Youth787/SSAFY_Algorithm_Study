import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			String s = br.readLine();
			int[] re = new int[26];
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
					re[s.charAt(i) - 'a']++;
				}
			}
			int max = 0;
			for (int r : re) {
				if (r > max) {
					max = r;
				}
			}

			int cnt = 0;
			int ans = 0;
			for (int j = 0; j < 26; j++) {
				if (max == re[j]) {
					cnt++;
					ans = j;
				}
			}
			if (cnt == 1)
				System.out.println((char)(ans + 'a'));
			else
				System.out.println("?");
		}
	}
}
