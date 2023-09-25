import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 밀비급일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		while (!s.equals("END")) { // 입력받은 문자열이 end가 아닐때까지. 
			Stack<Character> stack = new Stack<>(); // 스택 생성 
			for(int i=0; i<s.length(); i++) // 해당 문자열 길이만큼 
				stack.push(s.charAt(i)); // 스택에 추가 
			
			String result = ""; // 빈 문자열 변수 생성 
			for(int i=0; i<s.length(); i++) // 문자열 길이만큼 
				result += stack.pop();// 스택에서 뽑아서 더해주기 
			
			System.out.println(result); // 결과 출력 
			s = br.readLine(); // 새로 줄 받기 
		}// while end 
	}// main end 
}
