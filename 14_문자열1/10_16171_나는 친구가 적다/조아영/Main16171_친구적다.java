import java.util.Scanner;

public class Main16171_친구적다 {
	
	public static void main(String[] args) {
		
		String num = "0123456789";
		char[] numarr = num.toCharArray();
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String keyword = sc.next();
		
		char[] arr = new char[str.length()];
		int idx = 0; 
		for (int i=0; i<str.length(); i++) {
			for (int j=0; j<10; j++) {
				if (str.charAt(i)==numarr[j]) break;
				else if (j==9) arr[idx++] = str.charAt(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<idx; i++) {
			sb.append(arr[i]);
		}
		String newstr = sb.toString();
		
		int ans = 0;
		for (int i=0; i<idx-keyword.length()+1; i++) {
			if (newstr.substring(i, i+keyword.length()).equals(keyword)) {
				ans = 1; 
				break;
			}
		}
		System.out.println(ans);
		
	}

}
