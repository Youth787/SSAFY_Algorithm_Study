import java.util.*;
import java.io.*;

//8931. 제로
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW5jBWLq7jwDFATQ&
public class Solution8931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t=1; t<=tc; t++) {
			int k = Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<>();
			for (int i=0; i<k; i++) {
				int num = Integer.parseInt(br.readLine());
				if (num==0) stack.pop(); 
				else stack.push(num);
				
			}
			int ans = 0;
			while (!stack.isEmpty()) ans += stack.pop();
			System.out.printf("#%d %d\n",t,ans);
		}
	}
}
