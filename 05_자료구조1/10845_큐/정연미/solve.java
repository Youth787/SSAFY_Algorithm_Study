import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐_10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		int last = 0;
		
		for(int tc =1 ; tc<=N; tc++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.equals("push")) {
				int a = Integer.parseInt(st.nextToken());
				queue.offer(a);
				last = a;
			}else if(s.equals("size")) 
				System.out.println(queue.size());
			else if(s.equals("empty")) 
				System.out.println(queue.isEmpty()?1:0);
			else if(s.equals("pop")) {
				if(queue.isEmpty()) System.out.println("-1");
				else System.out.println(queue.poll());
			}else if(s.equals("front")){
				if(queue.isEmpty()) System.out.println("-1");
				else System.out.println(queue.peek());
			}else if(s.equals("back")){
				if(queue.isEmpty()) System.out.println("-1");
				else System.out.println(last);
			}
		} // test case end 
	} // main end
}
