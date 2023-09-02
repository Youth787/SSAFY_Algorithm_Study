import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++)
			queue.add(i);

		int count = 0;
		sb.append("<");
		while (!queue.isEmpty()) {
			count++;
			if (count % K == 0) {
				sb.append(queue.poll());
				if (!queue.isEmpty())
					sb.append(", ");
			} else
				queue.add(queue.poll());
		}
		sb.append(">" + "\n");
		System.out.println(sb);
	}// main end
}
