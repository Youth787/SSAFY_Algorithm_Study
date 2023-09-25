import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		int cnt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {

			String s = br.readLine();
			boolean visited[] = new boolean[26]; // 알파벳 사용 내역 확인
			boolean check = true; // 그룹 단어 인지 확인

			for (int j = 0; j < s.length(); j++) {
				if (visited[(s.charAt(j) - 'a')]) {
					if (s.charAt(j) != s.charAt(j - 1)) {
						check = false;
						break;
					}
				} else {
					visited[(s.charAt(j) - 'a')] = true;
				}
			}
			if (check) {
				cnt++;
			}

		}

		System.out.println(cnt);
	}
}
