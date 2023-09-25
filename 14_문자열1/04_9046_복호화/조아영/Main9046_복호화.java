import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9046_복호화 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t=1; t<=tc; t++) {
			String str = br.readLine(); //주어진 문자열 
			
			//알파벳 빈도수 체크 위한 배열 생성 
			String apb = "abcdefghijklmnopqrstuvwxyz"; 
			char[] alphabet = new char[26];
			int[] frq = new int[26];
			for (int i=0; i<26; i++) {
				alphabet[i] = apb.charAt(i);
			}
			
			//주어진 문자열의 알파벳 빈도수 체크 
			for (int i=0; i<str.length(); i++) {
				char tmp = str.charAt(i);
				for (int j=0; j<26; j++) {
					if (tmp==alphabet[j]) {
						frq[j]++;
					}
				}	
			}
			
			//제일 많이 나온 알파벳 찾음 
			int max = 0; 
			char ans = ' ';
			int cnt = 0; 
			for (int i=0; i<26; i++) {
				if (frq[i]>max) {
					max=frq[i]; 
					ans=alphabet[i];
				}
			}
			
			//걔가 몇번 나왔는지 체크 
			for (int i=0; i<26; i++) {
				if (frq[i]==max) cnt++; 
			}
			
			//횟수 따라서 정답 출력
			if (cnt==1) System.out.println(ans);
			else System.out.println("?");
		}
		
	}

}
