import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//절대값 기준으로 앞 값이 더 크다면 자리를 바꿔준다.
				if(Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				//절대값 기준으로 두 값이 같다면 음수를 앞으로 보내준다.
				}else if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}else {
					return -1;
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) sb.append("0").append("\n");
				else sb.append(pq.poll()).append("\n");
			}else {
				pq.offer(x);
			}
		}
		System.out.println(sb);
	}

}
