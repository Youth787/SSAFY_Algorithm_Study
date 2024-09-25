import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int start = 0;
        Stack<Integer> s = new Stack<>();
        while (n-- > 0) { // n이 0보다 클때 돌아돌아
        	int now = Integer.parseInt(br.readLine()); // 숫자 받아오고
        	if (now > start) { // 만약 내 현재 값(start)보다 크다면 숫자를 스택에 넣어주고 + 출력
        		for (int i = start + 1; i <= now; i++) {
        			s.push(i);
        			sb.append("+").append("\n");
        		}
        		start = now; // 현재 값 초기화!!!!
        	} else if (s.peek() != now) { // top에 있는 원소가 입력받은 값과 다른 경우는 no
        		System.out.println("NO");
        		return;
        	}
        	s.pop(); // now값 까지 push가 되어있다면 pop을 해준다.
        	sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
    
}

//https://st-lab.tistory.com/182
