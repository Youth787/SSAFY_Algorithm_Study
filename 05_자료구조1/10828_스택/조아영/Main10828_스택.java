import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10828_스택 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int commands = Integer.parseInt(br.readLine());
		int[] stack = new int[commands]; 
		int cnt = -1;
		
		String input=""; 
		while ((input=br.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(input," "); 
//			if (!st.hasMoreTokens()) break;
			switch (st.nextToken()) {
			case "push":
				stack[++cnt]=Integer.parseInt(st.nextToken());
				break;
			case "pop":
				if (cnt!=-1) {
					System.out.println(stack[cnt]);
					stack[cnt--]=0;
				}
				else System.out.println(cnt);
				break;
			case "size":
				if (cnt!=-1) System.out.println(cnt+1);
				else System.out.println(0);
				break;
			case "empty":
				if (cnt!=-1) System.out.println(0);
				else System.out.println(1);
				break;
			case "top":
				if (cnt!=-1) System.out.println(stack[cnt]);
				else System.out.println(cnt);
				break;
			}
			
		}
		
	}

}
