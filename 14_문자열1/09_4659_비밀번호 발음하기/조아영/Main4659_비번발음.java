import java.util.Scanner;

public class Main4659_비번발음 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String tmp = sc.next();
		String moeum = "aeiou";
		char[] moeumarr = moeum.toCharArray();
		
		boolean ans = false; 
		while (tmp!="end") {
		
			boolean  check = false;
			outer: for (int i=0; i<tmp.length(); i++) {
				for (int j=0; j<5; j++) {
					if (tmp.charAt(i)==moeumarr[j]) {//모음 있는지 체크 
						check = true; //있으면 true 
						break outer;
					}
				}
			}
			
			if (check) { //모음 있으면 마저 검사 진행  
				//ㅠㅠ 
			}

			StringBuilder sb = new StringBuilder();
			sb.append("<").append(tmp).append(">");
			if (ans) sb.append(" is acceptable.");
			else sb.append(" is not acceptable.");
			System.out.println(sb.toString());
			
			tmp = sc.next(); 
			
		}
	}

}
