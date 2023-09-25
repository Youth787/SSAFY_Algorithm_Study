import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String w = "";
		String s = br.readLine();
		String f = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9))
				w += s.charAt(i);
		}
		System.out.println(w.indexOf(f) != -1 ? 1 : 0);

	}
}
