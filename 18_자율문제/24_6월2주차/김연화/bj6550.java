import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 백준알고리즘 6550번 부분 문자열

	static String s;
	static String t;
	static String str;
	static int idx;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			str = br.readLine();
			if(str == null) break;
		

			st = new StringTokenizer(str);

			s = st.nextToken();
			t = st.nextToken();

			idx = 0;

			for (int i = 0; i < t.length(); i++) {
				if (s.charAt(idx) == t.charAt(i)) {
					idx++;
				}
				if (idx == s.length()) {
					break;
				}
			}

			if (idx == s.length()) {
				sb.append("Yes").append('\n');
			} else {
				sb.append("No").append('\n');
			}

		}
		System.out.println(sb);

	}

}
