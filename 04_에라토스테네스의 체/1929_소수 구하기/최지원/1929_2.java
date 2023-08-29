//시간초과2
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[문제] m이상 n이하의 소수를 모두 출력
 * */
public class Main {

	public static void main(String[] args)  throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String tmp = br.readLine();
		String [] temp = tmp.split(" ");
		int m = Integer.parseInt(temp[0]); //m 이상
		int n = Integer.parseInt(temp[1]); //n 이하
		
		StringBuilder sb =new StringBuilder();
		
		for (int i = m; i<=n; i++) {
			int cnt=0;
			for (int j = 2;j<=i; j++) {
				if (i%j ==0) cnt++;
			}
			if (cnt ==1) {
				sb.append(i).append('\n');
			}
		} //m~n 사이
		
		System.out.println(sb);
	} //main
} //class
