import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			if (s.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));

			} else if (s.equals("pop")) {
				if (!stack.empty())
					sb.append(stack.pop()).append("\n");

				else
					sb.append(-1).append("\n");
			}

			else if (s.equals("size")) {
				sb.append(stack.size()).append("\n");
			}

			else if (s.equals("empty")) {
				if (!stack.empty())
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
			}

			else {
				if (!stack.empty())
					sb.append(stack.peek()).append("\n");
				else
					sb.append(-1).append("\n");
			}

		}
		System.out.println(sb);
	}
}
