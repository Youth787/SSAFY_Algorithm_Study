import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if(c == '(') {
					stack.push(c);
				}
				else {
					int size = stack.size();
					if(size == 0) {
						stack.push(c);
						break;
					}
					else {
						stack.pop();
					}
				}
				
			}
			if(stack.isEmpty()) {
				System.out.println("YES");
				
			}
			else {
				System.out.println("NO");
			}
			stack.clear();
		}

	}

}
