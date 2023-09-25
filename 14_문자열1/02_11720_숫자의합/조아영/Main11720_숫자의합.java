import java.util.Scanner;

public class Main11720_숫자의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		int sum = 0; 
		for (int i=0; i<n; i++) {
			sum = sum + str.charAt(i) - 48;
		}
		System.out.println(sum);
		
	}
}
