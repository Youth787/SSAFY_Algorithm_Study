import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 완탐_Main16637_괄호추가 {
	
	static List<Integer> nums;
	static List<Character> ops;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String expression = sc.next(); //수식
		nums = new ArrayList<>(); //숫자
		ops = new ArrayList<>(); //연산기호
		
		for (int i=0; i<n; i++) {
			char c = expression.charAt(i);
			if (c=='+' || c=='-' || c=='*') ops.add(c);
			else nums.add(c-'0');
		}
		
		dfs(nums.get(0),0);
		System.out.println(ans);
		
	}
	
	static void dfs(int total, int idx) {
		
		if (idx>=ops.size()) { //입력받은 연산자 개수를 초과하면 최댓값 비교하고 리턴  
			ans = Math.max(ans, total); 
			return;
		}
		
		//괄호가 없는 경우
		int num1 = calc(ops.get(idx), total, nums.get(idx+1));
		dfs(num1, idx+1); 
		
		//괄호가 있는 경우 
		if (idx+1 < ops.size()) {
			int num2 = calc(ops.get(idx+1), nums.get(idx+1), nums.get(idx+2)); //total의 오른쪽에 있는 값을 연산함 
            dfs(calc(ops.get(idx), total, num2), idx+2); // 현재 result와 방금 구한 괄호 값을 연산한 결과와 괄호 오른쪽에 존재하는 연산자의 인덱스를 넘김.
		}
		
	}
	
	static int calc(char op, int n, int m) { //연산 메소드 
		if (op=='+') return n+m;
		else if (op=='-') return n-m;
		else return n*m;
		}
	
}
