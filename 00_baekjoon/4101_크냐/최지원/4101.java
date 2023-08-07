import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//마지막 입력은 0 0
		int a = sc.nextInt();
		int b = sc.nextInt();
		while (a!=0 && b!=0) {
			if (a>b) 
				System.out.println("Yes");
			else
				System.out.println("No");
			a=sc.nextInt();
			b=sc.nextInt();
		}

	}
}
