import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이구역의승자는누구야 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[] {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
		int[] rearr = new int[s.length()];
		for(int i=0; i<s.length(); i++) 
			rearr[i] = arr[s.charAt(i)-'A'];
		
		int sum =0;
		for(int i=0 ;i<s.length(); i++) {
			sum+=rearr[i];
			sum = sum%10;
		}
		
		if(sum %2 ==1) System.out.println("I'm a winner!");
		else System.out.println("You're the winner?");
	}
}
