import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String arr[] = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr, new Comparator<String>() { // 비교
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		System.out.println(arr[0]);
		for (int j = 1; j < n; j++) {
			if (arr[j].equals(arr[j - 1]))
				continue;
			else
				System.out.println(arr[j]);
		}
	}
}
