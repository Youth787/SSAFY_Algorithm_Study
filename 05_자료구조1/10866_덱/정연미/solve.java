import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 덱_10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> deque = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int tc =1 ; tc<=N; tc++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("push_back")) {
				int a = Integer.parseInt(st.nextToken());
				deque.offerLast(a);
			}else if(s.equals("push_front")) {
				int a = Integer.parseInt(st.nextToken());
				deque.offerFirst(a);
			}else if(s.equals("size")) 
				sb.append(deque.size()+"\n");
			else if(s.equals("empty")) 
				sb.append(deque.isEmpty()?1+"\n":0+"\n");
			else if(s.equals("pop_front")) {
				if(deque.isEmpty()) sb.append("-1"+"\n");
				else sb.append(deque.pollFirst()+"\n");
			}else if(s.equals("pop_back")) {
				if(deque.isEmpty()) sb.append("-1"+"\n");
				else sb.append(deque.pollLast()+"\n");
			}else if(s.equals("front")){
				if(deque.isEmpty()) sb.append("-1"+"\n");
				else sb.append(deque.getFirst()+"\n");
			}else if(s.equals("back")){
				if(deque.isEmpty()) sb.append("-1"+"\n");
				else sb.append(deque.getLast()+"\n");
			}
		} // test case end 
		System.out.println(sb);
	} // main end
}
