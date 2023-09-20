import java.util.Scanner;

public class Main9655_돌게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n%2==1) System.out.println("SK");
		else System.out.println("CY");
		//직접 세어보면 돌이 홀수개일 때 상근이가 이기고 짝수개일 땐 창영이가 이김...
	}
}
