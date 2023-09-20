import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간초과 
public class Main18258_큐2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int commands = Integer.parseInt(br.readLine());
		int[] queue = new int[commands+1]; 
		int front = 0; 
		int back = 0; 
		StringTokenizer st; 
		
		for (int c=1; c<=commands; c++) {
			st = new StringTokenizer(br.readLine()," "); 
			switch (st.nextToken()) {
			case "push":
				queue[++back]=Integer.parseInt(st.nextToken());
				break;
			case "pop":
				if (front!=back) {
					System.out.println(queue[front+1]);
					queue[front+1]=0;
					front++;
				}
				else System.out.println(-1);
				break;
			case "size":
				if (front!=back) System.out.println(back-front);
				else System.out.println(0);
				break;
			case "empty":
				if (front!=back) System.out.println(0);
				else System.out.println(1);
				break;
			case "front":
				if (front!=back) System.out.println(queue[front+1]);
				else System.out.println(-1);
				break;
			case "back":
				if (front!=back) System.out.println(queue[back]);
				else System.out.println(-1);
				break;
			}
				
		}
			

	}
	
}
