import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9012_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			char[] arr = br.readLine().toCharArray();
			if (arr.length%2==1) {
				System.out.println("NO"); 
				continue;
			} else {
				char[] stack = new char[arr.length];
				int top = -1;  
				for (int j=0; j<arr.length; j++) {
					if (arr[j]=='(') stack[++top]=arr[j];
					else if (arr[j]==')' && top>-1 && stack[top]=='(') {
						stack[top]=' ';
						top--;
					} else if (arr[j]==')' && top==-1) {
						System.out.println("NO");
						break;
					}
					if (j==arr.length-1) {
						if (top==-1) System.out.println("YES");
						else System.out.println("NO");
					}
				}
			}
			
		}
	}
}
