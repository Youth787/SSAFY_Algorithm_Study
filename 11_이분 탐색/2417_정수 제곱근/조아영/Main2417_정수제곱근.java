import java.util.Scanner;

public class Main2417_정수제곱근 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long l = sc.nextLong();
		long sqrt = (long) Math.sqrt(l);
		
		//땡스 투 지원 
		if (sqrt*sqrt<l) sqrt++;
		System.out.println(sqrt);

		//틀렸어
//		if (sqrt*sqrt!=l) System.out.println(sqrt+1);
//		else System.out.println(sqrt);
		
		//이것도 틀렸어 
//		if (sqrt*sqrt==l) System.out.println(sqrt);
//		else System.out.println(sqrt+1);
		
	}
	
}
