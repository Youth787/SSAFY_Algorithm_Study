package 문자열1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의합_11720 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum =0;
		String S = br.readLine();
		for(int i =0; i<N; i++) {
			sum += S.charAt(i)-'0';
		}
		System.out.println(sum);
	}
}
