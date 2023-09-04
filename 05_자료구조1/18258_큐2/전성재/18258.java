import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		int back = 0;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("push")) {
				back = Integer.parseInt(st.nextToken());
				q.offer(back);

			} else if (s.equals("pop")) {
				if (q.isEmpty()) {
					sb.append("-1").append("\n");

				} else {
					sb.append(q.poll()).append("\n");

				}
			} else if (s.equals("size")) {
				sb.append(q.size()).append("\n");

			} else if (s.equals("empty")) {
				if (q.isEmpty()) {
					sb.append("1").append("\n");

				} else {
					sb.append("0").append("\n");

				}
			} else if (s.equals("front")) {
				if (q.isEmpty()) {
					sb.append("-1").append("\n");

				} else {
					sb.append(q.peek()).append("\n");

				}
			} else if (s.equals("back")) {
				if (q.isEmpty()) {
					sb.append("-1").append("\n");

				} else {
					sb.append(back).append("\n");

				}
			}
		}
		System.out.println(sb);
	}
}
