import java.util.Scanner;

public class Main4659_비번발음 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String pw = sc.next();
		String moeum = "aeiou";
		char[] moeumarr = moeum.toCharArray();
		
		
		while (!pw.equals("end")) {
			
			boolean ans = false; 
		
			char[] pwarr = pw.toCharArray(); //단어를 글자배열로
			boolean[] pwmoeum = new boolean[pw.length()]; //글자중 모음 어딨는지 체크
			boolean  moeumYes = false; 
			for (int i=0; i<pw.length(); i++) {
				for (int j=0; j<5; j++) {
					if (pw.charAt(i)==moeumarr[j]) {//모음 있는지 체크 
						moeumYes = true; //있으면 true 
						pwmoeum[i] = true; //글자배열에 위치 표시 
					}
				}
			}
			
			boolean followingYes = false;
			boolean lastYes = false; 
			
			if (moeumYes) { //모음 있으면 
				followingYes = true; //모음or자음 연달아 3개 있는지 체크 
				for (int i=0; i<pw.length()-2; i++) {
					if ((pwmoeum[i] && pwmoeum[i+1] && pwmoeum[i+2]) || 
							(!pwmoeum[i] && !pwmoeum[i+1] && !pwmoeum[i+2])) {
						followingYes = false;
						break;
					}
				}
				
			}
				
			if (moeumYes && followingYes) { //1번, 2번 규칙 모두 충족되면 3번 실행 
				lastYes = true; 
				for (int i=0; i<pw.length()-1; i++) {
					if (pwarr[i]==pwarr[i+1] && pwarr[i]!='e' && pwarr[i]!='o') {
						//같은 글자가 연달아 오는데 그게 ee도 oo도 아니면 
						lastYes = false;
						break;
					}
				}
			}
			
			if (moeumYes && followingYes && lastYes) ans = true;

			StringBuilder sb = new StringBuilder();
			sb.append("<").append(pw).append(">");
			if (ans) sb.append(" is acceptable.");
			else sb.append(" is not acceptable.");
			System.out.println(sb.toString());
			
			pw = sc.next(); 
			
		}
	}

}
