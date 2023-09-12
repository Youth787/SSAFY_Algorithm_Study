import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1927_최소힙 {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		//우선순위 큐는 최소 힙으로 구현되어 있음
		//즉 숫자를 넣으면 뺄 때마다 가장 작은 값이 출력 후 삭제됨 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //명령의 개수 
		for (int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine()); //스캐너는 시간 초과 뜸 
			if (tmp!=0) pq.add(tmp); //자연수면 pq에 넣음 
			else if (tmp==0 && pq.size()!=0) System.out.println(pq.remove()); //내용물 있으면 꺼냄 
			else System.out.println(0); //내용물 없는데 꺼내라고 하면 0 출력
		}
	}
}
