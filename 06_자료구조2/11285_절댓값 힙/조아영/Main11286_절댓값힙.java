import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main11286_절댓값힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				int A = Math.abs(a);
				int B = Math.abs(b);
				if (A>B) return A-B;
				else if (A==B) {
					if (a>b) return 1; 
					else return -1; 
				} 
				else return -1; 
			}
		});
		
		//while(n-->0){ } //이렇게도 구현 가능하네 신기하다 
		for (int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num!=0) pq.add(num);
			else if (num==0 && pq.size()!=0) System.out.println(pq.remove());
			else System.out.println(0);
		}

	}
}
