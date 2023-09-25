import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int cnt = 0; // 그룹 단어 개수를 셀 변수 
		
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine(); // 문자를 받는다. 
			boolean[] boo = new boolean[26]; // 알파벳 개수 
			boolean result = true; // 시작은 true로 
			
			out : for(int i=0; i<s.length(); i++){
				if(boo[s.charAt(i)-'a']) { // 이미 문자열안에 존재했다면 
					if(i-1>=0 && s.charAt(i-1)-'a' != s.charAt(i)-'a') { // 바로 앞과 같은지 확인 
						result = false; // 같지 않으면 그룹 단어 아님. 
						break out; // 다음 확인할것도 없음 
					}
				}
				boo[s.charAt(i)-'a'] = true; // break로 빠지지 않았다면 해당 문자 존재한다 체크 
			}
			
			if(result) cnt++; // 그룹단어가 존재라면 cnt 개수 증가 
			
		}// test case end
		System.out.println(cnt);
	}// main end 
}
