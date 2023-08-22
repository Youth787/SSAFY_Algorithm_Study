
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner (System.in);
		int N = sc.nextInt();
		int num1 = N%10; //일의 자리
		int num2 = N/10 + num1; //각 자리수 합
		int num3 = (num1*10)+num2%10; //일의자리를 서로 붙인다
		int cnt = 0;
		if (num3 == N) {
			System.out.println(1); //사실 0인 경우 때문에 껴놓은 부분
		} else {
			while (num3 != N ) {
				cnt++;
				num1 = num3%10;
				num2 = num3/10 +num1;
				num3 = num1*10 + num2%10;

				if (num3 == N) {
					cnt++;
					break;
				}

			}
			System.out.println(cnt);
		}
	}

}
