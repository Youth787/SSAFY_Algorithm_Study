import java.util.Scanner;

public class Main1316_그룹단어체커 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] words = new String[n];
		for (int i=0; i<n; i++) {
			words[i]=sc.next();
		}
		
		String apb = "abcdefghijklmnopqrstuvwxyz";
		char[] apbarr= apb.toCharArray();
		
		int ans = n; 
		
		for (int i=0; i<n; i++) {
			String str = words[i];
			boolean test[] = new boolean[26];
			
			for (int j=0; j<str.length(); j++) {
				if (str.charAt(j)!=str.charAt(i+1)) {
					for (int k=0; k<26; k++) {
						if (test[k]==true) {
							ans--;
							break;
						}
					}
					test[str.charAt(j)]=true;
				}
			}
			System.out.println(ans);
		}
		
	}
}
