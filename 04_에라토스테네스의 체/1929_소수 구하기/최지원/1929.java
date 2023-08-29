
import java.util.Scanner;

/*
[문제] m이상 n이하의 소수를 모두 출력
 * */
public class Main {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int m = sc.nextInt(); //m 이상
		int n = sc.nextInt(); //n 이하
		
		//~100까지의 소수구하기 https://parkdream.tistory.com/59
		
		for (int i = m; i<=n; i++) {
			int cnt=0;
			for (int j = 2;j<=i; j++) {
				if (i%j ==0) cnt++;
			}
			if (cnt ==1) {
				System.out.println(i+" ");
			}
		} //m~n 사이
	} //main
} //class
