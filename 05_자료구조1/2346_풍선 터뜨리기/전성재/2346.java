import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<int[]> d = new ArrayDeque<int[]>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int[] tmp = { i, Integer.parseInt(st.nextToken()) };
			d.add(tmp);
		} // deque에 넣기
		while (d.size() > 1) {
			int[] tmp = d.pollFirst();
			sb.append(tmp[0]).append(" ");
			int n = tmp[1];
			if (n > 0) {
				for (int j = 1; j < n; j++) {
					d.offerLast(d.pollFirst());
				}
			} else if (n < 0) {
				for (int j = n; j != 0; j++) {
					d.offerFirst(d.pollLast());
				}
			}

		}
		sb.append(d.poll()[0]);
		System.out.println(sb);
	}
}
