import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나는친구가적다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String str = s.replaceAll("[0-9]", ""); // 정규표현식 ^ : 제외하라는 의미
		// String str = s.replaceAll("[0-9]", ""); 0~9를 모두 공백으로 만들어라.
		// String str = s.replaceAll("[^0-9]", ""); 0~9 제외하고 나머지 모두 공백으로 만들어라.
		String v = br.readLine();
		boolean result = false; // 초기값은 false로 잡기. 

		out: for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == v.charAt(0)) { // 시작 문자가 같으면 
				int cnt = 0; // 개수를 세기 시작하자 
				for (int j = 0; j < v.length(); j++) { // 문자열 v의 길이만큼 돌려 
					if (str.charAt(i + j) == v.charAt(j)) { // 계속 같으면 
						cnt++; // 개수 ++ 
					}else continue out; // 같지않은 부분 나타나면 out for 문으로 가서 다시 찾기 
				}
				if (cnt == v.length()) { // 전부 다 같았으면 
					result = true; // 존재한다 같은 문자열이 
					break out; // 더이상 검사할것 없으니 나가버리자 
				}
			}
		}
		System.out.println(result ? "1" : "0"); // 결과를 출력하자 
	}// main end
}