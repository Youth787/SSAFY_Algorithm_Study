//package p4659_비밀번호발음하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//모음aeiou 하나 반드시 포함, 모음이 3개 혹은 자음이 3개 연속으로 오면 안됨. 같은 글자가 연속적으로 2번 오면 안되지만 ee oo허용
//[입력] 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(!str.equals("end")) {
			char [] tmp = str.toCharArray();
			//기준 1: 모음이 하나라도 있어야
			boolean one = false;
			for (int i = 0; i< tmp.length; i++) {
				if (tmp[i] == 'a' ||tmp[i] == 'e' ||tmp[i] == 'i' ||tmp[i] == 'o' ||tmp[i] == 'u' ) {
					one = true;
					break;
				}
			}
			//기준 2: 모음이 3개 혹은 자음이 3개 연속으로 오면 안된다
			boolean [] twoo = new boolean [tmp.length];
			boolean two = true;
			for (int i = 0; i< tmp.length; i++) {
				if (tmp[i] == 'a' ||tmp[i] == 'e' ||tmp[i] == 'i' ||tmp[i] == 'o' ||tmp[i] == 'u' ) twoo[i] = true;				
			}
			for (int i = 0; i< tmp.length-2; i++) {
				if ( twoo[i] && twoo[i+1] && twoo[i+2]) {
					two = false;
					break;
				}
				else if ( !twoo[i] && !twoo[i+1] && !twoo[i+2]) {
					two = false;
					break;
				}
			}

			//기준 3: 같은 글자가 연속적으로 2번 오면 안됨
			boolean three = true;
			for (int i = 0; i< tmp.length-1; i++) {
				if (tmp[i]==tmp[i+1]) {
					if (tmp[i] =='e' || tmp[i] == 'o') continue;
					else {
						three = false;
						break;
					}
				}
			}
			
			if (one && two && three) System.out.println("<"+str+"> is acceptable.");
			else System.out.println("<"+str+"> is not acceptable.");
			
			str = br.readLine();
		}//tc
	}//main
}//class
