package p1357_뒤집힌덧셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Rev(x) = x의 모든 자리수가 역순이 된 수를 만드는 함수
 * x와 y -> Rev(Rev(x)+Rev(y))
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String x = st.nextToken();
		String y = st.nextToken();
		
		int tmp = Integer.parseInt(reverse(x)) + Integer.parseInt(reverse(y)); 
		int ans = Integer.parseInt(reverse(Integer.toString(tmp)));
		System.out.println(ans);
		
	} //main
	
	static String reverse(String str) {
		String result ="";
		for (int i = str.length()-1; i >= 0; i--) {
			result += str.charAt(i);
		}
		return result;
	} //reverse

} //class
