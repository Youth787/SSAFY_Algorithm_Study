import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선터뜨리기_2346 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		Deque<Integer> idx = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			deque.offer(Integer.parseInt(st.nextToken()));
			idx.offer(i+1);
		}
		
		while (!deque.isEmpty()) {
			int a = deque.peek();
			System.out.print(idx.poll() + " ");
			deque.poll();
			if (!deque.isEmpty()&&a>=0) {
				for (int i = 0; i < a - 1; i++) {
					deque.offer(deque.poll());
					idx.offer(idx.poll());
				}
			}else if(!deque.isEmpty()&&a<0) {
				for(int i=0; i>a;i--) {
					deque.offerFirst(deque.pollLast());
					idx.offerFirst(idx.pollLast());
				}
			}
		}
	}
}
