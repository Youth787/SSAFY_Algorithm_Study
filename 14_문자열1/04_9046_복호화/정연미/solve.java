import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 복호화 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc=1;tc<=T; tc++) {
			int[] cnt = new int[26];
			String s = br.readLine();
			String news = s.replaceAll(" ","");

			for(int i=0; i<news.length(); i++) 
				cnt[news.charAt(i)-'a']++;
			
			int max =0, result =0, same =0; 
			for(int i=0; i<26; i++) {
				if(cnt[i]>max) {
					max = cnt[i]; result = i;
				}
			}
			
			for(int i=0; i< cnt.length; i++) 
				if(cnt[i]==max) same++;
			
			if(same >1) System.out.println("?");
			else System.out.println((char)(result+'a'));
		} // test case end
	}// main end
}
