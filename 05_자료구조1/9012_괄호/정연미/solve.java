import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if ((!stack.isEmpty()) && c == ')' && stack.peek() == '(') {
					stack.pop();
					continue;
				}
				stack.push(c);
			}
			System.out.println(stack.isEmpty() ? "YES" : "NO");
		} // test case end
	}// main end
}
