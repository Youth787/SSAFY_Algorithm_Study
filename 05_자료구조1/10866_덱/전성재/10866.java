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
		Deque<Integer> d = new ArrayDeque<Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch (s) {
			case "push_front":
				d.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				d.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (d.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(d.pollFirst()).append("\n");
				break;

			case "pop_back":
				if (d.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(d.pollLast()).append("\n");
				break;
			case "size":
				sb.append(d.size()).append("\n");
				break;

			case "empty":
				if (d.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;

			case "front":
				if (d.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(d.peekFirst()).append("\n");
				break;

			case "back":
				if (d.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(d.peekLast()).append("\n");
				break;

			}
		}
		System.out.println(sb);
	}
}
