import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] arr = new char[5][15];
		int max = 0;

		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			if (max < s.length()) // 가장 긴 문자열 체크
				max = s.length();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j][i] == '\0') // char 배열의 초깃값 = '\0'
					continue;
				System.out.print(arr[j][i]);
			}
		}

	}
}
