import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 우선순위큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0) {
				if (pq.size() == 0)
					sb.append(0 + "\n");
				else
					sb.append(pq.poll() + "\n");
			} else
				pq.offer(a);
		}// 입력받기 완료
		System.out.print(sb);
	}// main end 
}
