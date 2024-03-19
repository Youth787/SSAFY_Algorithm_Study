import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			Stack<Character> stack = new Stack<Character>();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					stack.add('(');
				} else if (str.charAt(j) == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						stack.add(')');
					}

				}
			}
			if (stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
