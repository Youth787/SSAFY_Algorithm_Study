package p10799_쇠막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ()는 레이저, (는 막대 왼쪽 끝, )는 오른쪽 끝
 * 잘려진 쇠막대 총 조각 구하기
 * 
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String str = br.readLine();
		
		int sum = 0; //잘려진 막대 수
		int cnt = 0; //지금 몇개 겹쳐 있나
		int idx = 0;
		
		while (idx < str.length()) {
			if (idx < str.length()-1 && str.substring(idx, idx+2).equals("()")) {
				sum += cnt;
				idx += 2;
			} else if (str.charAt(idx) == '(') {
				cnt++;
				idx++;
			} else {
				sum++;
				cnt--;
				idx++;
			}
			
		}
		sum += cnt;
		
		System.out.println(sum);
		
	} //main

} //class
