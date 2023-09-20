import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class solve {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (Math.abs(o1) == Math.abs(o2)) { // 절댓값이 같을 경우 
				return o1 - o2; 
				// o1 이 더 크다면 양수를 반환한다. = o1과 o2 자리를 바꾼다.
				// o1이 더 작다면 음수 반환 -> 지금의 자리를 유지한다
			} else { //절댓값이 같지 않은 경우 절댓값이 작은 순서로 정렬한다
				return Math.abs(o1) - Math.abs(o2);
				//양수가 반환되면 o1의 절댓값이 더 큰 경우이다 -> o2, o1순으로 정렬
                //음수가 반환되면 o2의 절대값이 더 큰 경우이다 -> o1, o2 유지
			}
		});

		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0) {
				if (pq.size()==0)
					sb.append(0 + "\n");
				else
					sb.append(pq.poll() + "\n");
			} else
				pq.offer(a);
		} // 입력받기 끝
		System.out.print(sb);
	}// main end 
}
