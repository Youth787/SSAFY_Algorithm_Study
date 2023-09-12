import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main11279_최대힙 {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());	
			if (tmp!=0) pq.add(-tmp); //음수로 바꿔서 넣음
			else if (tmp==0 && pq.size()!=0) System.out.println(-pq.remove()); //출력 시 부호 바꿔줘야 
			else System.out.println(0);
		}
	}	
}
