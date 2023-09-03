import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐2_18258 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
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
				sb.append(queue.size()+"\n");
			else if(s.equals("empty")) 
				sb.append(queue.isEmpty()?1+"\n":0+"\n");
			else if(s.equals("pop")) {
				if(queue.isEmpty()) sb.append("-1"+"\n");
				else sb.append(queue.poll()+"\n");
			}else if(s.equals("front")){
				if(queue.isEmpty()) sb.append("-1"+"\n");
				else sb.append(queue.peek()+"\n");
			}else if(s.equals("back")){
				if(queue.isEmpty()) sb.append("-1"+"\n");
				else sb.append(last+"\n");
			}
		} // test case end 
		System.out.println(sb);
	} // main end
}

