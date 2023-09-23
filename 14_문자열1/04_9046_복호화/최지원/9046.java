//package p9046_복호화;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//[문제] 암호문 알파벳 빈도수를 체크하여 가장 빈도수가 높은 문자 출력. 여러개일 경우 ?출력
//[입력] t / t줄 동안 암호문
public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt(); //테케 수
		sc.nextLine();
		for (int tc = 1; tc<=t;tc++) {
			char [] tmp = sc.nextLine().toCharArray();//한 줄 읽고
			//26개 알파벳 빈도수 체크. 그냥 아스키코드 사용해서 체크
			//a = 141 ~ z = 172 (172-141+1 = 32)
			int [] chk  = new int[32];

			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i]==' ') continue;
				chk[tmp[i]-'a']++;//[1]에는 몇번 나왔나. -'0'하듯이
			}
			
			//빈도수 가장 높은 친구 뭔지
			char ans = '?';//정답 알파벳
			int max = 0;//빈도수 최고
			
			for (int i = 0; i < chk.length; i++) {
				if (max < chk[i]) {
					ans = (char)(i+97);
					max = chk[i];
				} else if (max == chk[i]) {//같은 빈도수가 나왔으면 아니야...
					ans = '?';
				}
			}
			System.out.println(ans);

		}//tc
	}//main
}//class
