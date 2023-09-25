import java.util.Scanner;

public class Main11365_밀비급일 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String pw = sc.nextLine();

		while (!pw.equals("END")) {
			
			char[] tmp = pw.toCharArray();
			//System.out.println(Arrays.toString(tmp));
			int l = tmp.length;
			StringBuilder sb = new StringBuilder(); 
			for (int i=l-1; i>=0; i--) {
				sb.append(tmp[i]);
			}			
			String ans = sb.toString();
			System.out.println(ans);
			pw = sc.nextLine(); 
			
		}
		
	}
	
}
