import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> minq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxq = new PriorityQueue<Integer>(Comparator.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < N; tc++) {
			int n = Integer.parseInt(br.readLine());
			if (minq.size() == maxq.size()) {
				maxq.add(n);

			} else {
				minq.add(n);
			}
			
			if(!maxq.isEmpty() && !minq.isEmpty() && maxq.peek() > minq.peek()) {
				int tmp = maxq.poll();
				maxq.offer(minq.poll());
				minq.offer(tmp);
			}
			sb.append(maxq.peek()+"\n");
			
		}
		System.out.println(sb.toString());
		
	}
}
