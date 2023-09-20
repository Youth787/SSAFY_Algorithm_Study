import java.util.Scanner;

public class Main10870_피보나치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibo(n));
	}
	public static int fibo(int n) {
		if (n==0) return 0; 
		if (n==1) return 1;
		else {
			int tmp1 = fibo(n-1);
			int tmp2 = fibo(n-2);
			return tmp1+tmp2;
		}
	}
}
