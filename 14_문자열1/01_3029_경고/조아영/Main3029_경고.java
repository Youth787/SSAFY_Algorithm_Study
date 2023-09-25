import java.util.Scanner;

public class Main3029_경고 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String from = sc.next();
		String to = sc.next();
		String ans = "";
		
		if (from.equals(to)) ans = "24:00:00"; //최대 24시간인 것 고려해야 함 
		
		else {
			
			//현재시분초
			int fromh = Integer.parseInt(from.substring(0, 2));
			int fromm = Integer.parseInt(from.substring(3, 5));
			int froms = Integer.parseInt(from.substring(6, 8));
			
			//목표시분초
			int toh = Integer.parseInt(to.substring(0, 2));
			int tom = Integer.parseInt(to.substring(3, 5));
			int tos = Integer.parseInt(to.substring(6, 8));
			
			//정답시분초
			int ansh =toh-fromh;
			int ansm =tom-fromm;
			int anss =tos-froms; //일단 그냥 차이를 구함 
			
			//현재보다 미래 숫자가 작으면 알맞게 나오도록 처리해줘야 함 
			if (anss<0) {
				anss = anss+60; 
				ansm--; 
			}
			
			if (ansm<0) {
				ansm = ansm+60;
				ansh--;
			}
			
			if (ansh<0) {
				ansh = ansh+24;
			}
			
			//아래처럼 풀면 틀림
			//반례 : 12:00:01, 12:00:00이면 23:59:59 나와야 함 (feat.성재) 
//			if (toh<fromh) {
//				ansh = 24 - fromh + toh; 
//			}
//			if (tom<fromm) {
//				ansm = 60 - fromm + tom;
//				ansh--;
//			}
//			if (tos<froms) {
//				anss = 60 - froms + tos;
//				ansm--;
//			}
			
			StringBuilder sb = new StringBuilder();
			if (ansh<10) sb.append("0");
			sb.append(ansh);
			sb.append(":");
			if (ansm<10) sb.append("0");
			sb.append(ansm);
			sb.append(":");
			if (anss<10) sb.append("0");
			sb.append(anss);
			
			ans = sb.toString();
			
		}
		
		System.out.println(ans);
		
	}
	
}
