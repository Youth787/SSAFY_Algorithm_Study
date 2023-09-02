import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int tc =1 ; tc<=N; tc++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.equals("push")) stack.add(Integer.parseInt(st.nextToken()));
			else if(s.equals("top")){
				if(stack.isEmpty()) System.out.println("-1");
				else System.out.println(stack.peek());
			}else if(s.equals("size")) 
				System.out.println(stack.size());
			else if(s.equals("empty")) 
				System.out.println(stack.isEmpty()?1:0);
			else if(s.equals("pop")) {
				if(stack.isEmpty()) System.out.println("-1");
				else System.out.println(stack.pop());
			}
		} // test case end 
	} // main end 
}
