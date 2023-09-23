//package p1316_그룹단어체커;

import java.util.Scanner;

//[문제]단어 N개를 입력으로 받아 그룹 단어의 개수를 출력
//그룹 단어 = 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//단어 수
		sc.nextLine();
		int ans = 0;//그룹 단어 수
		for (int tc = 1; tc <= t ; tc++) {	
			char [] str = sc.nextLine().toCharArray();
			if (str.length == 1) {
				ans++;
				continue;
			}
			out : for (int i = 0 ; i < str.length-1; i++) {
				if (str[i] == str[i+1]) {
					//만약 마지막 검사 인덱스였다면 여기서 끝
					if(i == str.length-2) {
						ans++;
						break out;
					}
				}
				else {
					//i이후에는 i랑 같은 글자가 나오면 안됨
					for (int j = i+1; j <str.length; j++) {
						if (str[i] == str[j]) break out;
					}
				}
				//마지막검사가 여기까지 문제없이 왔다면 
				if (i == str.length-2 ) ans++;
			}
		}//tc		
		System.out.println(ans);
	}//main
}//class

